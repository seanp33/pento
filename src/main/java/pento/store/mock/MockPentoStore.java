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

    @Override
    public void write(Pento pento, PentoWriteHandler handler) {
        System.out.println("submitting write...");
        engine.submitWrite(pento, handler);
    }

    @Override
    public void read(PentoQuery query, PentoReadHandler handler) {
    }

    class MockPentoStoreEngine implements Runnable {

        private ExecutorService ioExecutor = Executors.newFixedThreadPool(50);

        private Map<Future<Pento>, PentoWriteHandler> writeHandlers = new HashMap<Future<Pento>, PentoWriteHandler>();

        private boolean isRunning = false;

        public synchronized void submitWrite(Pento pento, PentoWriteHandler handler) {
            writeHandlers.put(ioExecutor.submit(
                    new RandomLatencyWorker().execute(pento)), handler);
            if (!isRunning) run();
        }

        @Override
        public void run() {
            Iterator<Map.Entry<Future<Pento>, PentoWriteHandler>> it = writeHandlers.entrySet().iterator();
            while (it.hasNext()) {
                isRunning = true;
                Map.Entry<Future<Pento>, PentoWriteHandler> entry = it.next();
                Future<Pento> future = entry.getKey();
                if (future.isDone()) {
                    try {
                        Pento p = future.get(5, TimeUnit.SECONDS);
                        System.out.println("obtained Pento : " + p);
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

            System.out.println("engine now idle...waiting for additional submissions");

        }
    }

}
