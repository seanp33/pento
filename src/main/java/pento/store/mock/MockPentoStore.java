package pento.store.mock;

import com.google.common.util.concurrent.*;
import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.store.DefaultLocalPentoStore;
import pento.store.FailedPentoResponse;
import pento.store.PentoResponse;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MockPentoStore extends DefaultLocalPentoStore {

    private static final String THREAD_NAME_FORMAT = "PentoStoreEngineIO#%s";

    private ListeningExecutorService ioExecutor;

    public MockPentoStore() {
        ThreadFactory ioThreadPool = new ThreadFactoryBuilder().setNameFormat(THREAD_NAME_FORMAT).build();
        ioExecutor = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool(ioThreadPool));
    }

    public void close() throws Exception {
        //empty
    }

    @Override
    public void write(final Pento pento, final PentoWriteHandler handler) {
        ListenableFuture<PentoResponse> listenableFuture = ioExecutor.submit(new RandomLatencyWorker().execute(pento));
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
