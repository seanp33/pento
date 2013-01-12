package pento.store;

import com.google.common.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pento.handler.PentoReadHandler;
import pento.handler.PentoWriteHandler;
import pento.model.Distribution;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.FailedPentoResponse;
import pento.response.PentoResponse;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DefaultPentoStore implements PentoStore {

    protected final static Logger logger = LoggerFactory.getLogger(DefaultPentoStore.class);

    private static final String THREAD_NAME_FORMAT = "PentoStoreEngineIO#%s";

    private ListeningExecutorService ioExecutor;

    private PentoStoreWorkerFactory writeWorkerFactory;

    private PentoStoreWorkerFactory readWorkerFactory;

    public DefaultPentoStore(PentoStoreWorkerFactory readWorkerFactory, PentoStoreWorkerFactory writeWorkerFactory) {
        this.readWorkerFactory = readWorkerFactory;
        this.writeWorkerFactory = writeWorkerFactory;
        ThreadFactory ioThreadPool = new ThreadFactoryBuilder().setNameFormat(THREAD_NAME_FORMAT).build();
        ioExecutor = MoreExecutors.listeningDecorator(
                Executors.newCachedThreadPool(ioThreadPool));
    }

    public void close() throws Exception {
        ioExecutor.shutdown();
    }

    @Override
    public void write(final Pento pento, final Distribution distribution, final PentoWriteHandler handler, final WriterContext writerContext) {
        PentoStoreWorker worker = writeWorkerFactory.getInstance(writerContext);
        Callable callable = worker.execute(pento, distribution);
        ListenableFuture<PentoResponse> future = ioExecutor.submit(callable);

        Futures.addCallback(future, new FutureCallback<PentoResponse>() {
            public void onSuccess(PentoResponse response) {
                handler.success(response);
            }

            public void onFailure(Throwable thrown) {
                logger.error(thrown.getMessage());
                handler.failure(new FailedPentoResponse(pento, thrown));
            }
        });
    }

    @Override
    public void read(PentoQuery query, PentoReadHandler handler) {
    }


}
