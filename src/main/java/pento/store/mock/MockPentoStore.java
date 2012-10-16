package pento.store.mock;

import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.store.PentoStore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.*;

public class MockPentoStore implements PentoStore {

    private MockPentoStoreEngine engine = new MockPentoStoreEngine();
    private ExecutorService mgmt = Executors.newSingleThreadExecutor();;

    public MockPentoStore(){
	mgmt.submit(engine);
    }

    public void close() throws Exception{
	mgmt.shutdownNow();
    }

    @Override
    public void write(Pento pento, PentoWriteHandler handler) {
        engine.submitWrite(pento, handler);
    }

    @Override
    public void read(PentoQuery query, PentoReadHandler handler) {
    }

    class MockPentoStoreEngine implements Runnable{

        private ExecutorService ioExecutor = Executors.newFixedThreadPool(50);

        private Map<Future<Pento>, PentoWriteHandler> writeHandlers = new HashMap<Future<Pento>, PentoWriteHandler>();

        private volatile boolean isRunning = false;

        public synchronized void submitWrite(Pento pento, PentoWriteHandler handler) {
            writeHandlers.put(ioExecutor.submit(
                    new RandomLatencyWorker().execute(pento)), handler);
	    if(!isRunning) run();
        }

        @Override
        public void run(){
            if(Thread.currentThread().isInterrupted()){
		System.out.println("interrupted engine thread with " + writeHandlers.size() + " handlers in motion");
		writeHandlers.clear();
	    }else{
		Iterator<Map.Entry<Future<Pento>, PentoWriteHandler>> it = writeHandlers.entrySet().iterator();
		while (it.hasNext()) {               
		    isRunning = true;
		    Map.Entry<Future<Pento>, PentoWriteHandler> entry = it.next();
		    Future<Pento> future = entry.getKey();
		    try {
			Pento p = future.get(100, TimeUnit.MILLISECONDS);
			entry.getValue().success(p, new MockPentoResponse());
			it.remove();
		    } catch (InterruptedException e) {
			// TODO: panic
		    } catch (ExecutionException e) {
			// TODO: panic
		    } catch (TimeoutException e) {
			// TODO: panic
		    }
		}
	    }
            
	    isRunning = false;
            System.out.println("engine now idle...waiting for additional submissions");

        }
    }

}
