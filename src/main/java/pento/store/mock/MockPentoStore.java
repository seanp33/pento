package pento.store.mock;

import com.google.common.util.concurrent.*;
import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.FailedPentoResponse;
import pento.response.PentoResponse;
import pento.store.DefaultLocalPentoStore;
import pento.store.PentoStoreWorkerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MockPentoStore extends DefaultLocalPentoStore {

    private static final String THREAD_NAME_FORMAT = "PentoStoreEngineIO#%s";

    private ListeningExecutorService ioExecutor;

    private PentoStoreWorkerFactory writeWorkerFactory;

    private PentoStoreWorkerFactory readWorkerFactory;

    public MockPentoStore(PentoStoreWorkerFactory readWorkerFactory, PentoStoreWorkerFactory writeWorkerFactory) {
        this.readWorkerFactory = readWorkerFactory;
        this.writeWorkerFactory = writeWorkerFactory;
        ThreadFactory ioThreadPool = new ThreadFactoryBuilder().setNameFormat(THREAD_NAME_FORMAT).build();
        ioExecutor = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool(ioThreadPool));
    }

    public void close() throws Exception {
        //empty
    }

    @Override
    public void write(final Pento pento, final PentoWriteHandler handler) {
        ListenableFuture<PentoResponse> listenableFuture = ioExecutor.submit(writeWorkerFactory.getInstance().execute(pento));
        Futures.addCallback(listenableFuture, new FutureCallback<PentoResponse>() {
            public void onSuccess(PentoResponse response) {
                handler.success(response);
            }

            public void onFailure(Throwable thrown) {
                handler.error(new FailedPentoResponse(pento));
            }
        });
    }

    @Override
    public void read(PentoQuery query, PentoReadHandler handler) {
    }


}
