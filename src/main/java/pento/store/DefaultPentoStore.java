package pento.store;

import com.google.common.util.concurrent.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pento.handler.PentoCallback;
import pento.model.Distribution;
import pento.model.Pento;
import pento.op.PentoQuery;
import pento.response.read.FailedPentoReadResponse;
import pento.response.read.PentoReadResponse;
import pento.response.write.FailedPentoWriteResponse;
import pento.response.write.PentoWriteResponse;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

import java.util.List;
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
    public void write(final Pento pento, final Distribution distribution, final PentoCallback handler, final OperationContext operationContext) {
        List<PentoStoreWorker> workers = writeWorkerFactory.getWorkers(operationContext, distribution);
        for (PentoStoreWorker worker : workers) {
            Callable callable = worker.execute(pento);
            ListenableFuture future = ioExecutor.submit(callable);

            Futures.addCallback(future, new FutureCallback() {
                public void onSuccess(Object response) {
                    handler.callback(response);

                    // OR
                    // handler.rejection();
                    // handler.error();
                }

                public void onFailure(Throwable thrown) {
                    logger.error(thrown.getMessage());
                    handler.error(thrown);
                }
            });
        }
    }

    @Override
    public void read(final PentoQuery query, final Distribution distribution, final PentoCallback handler, final OperationContext operationContext) {
        List<PentoStoreWorker> workers = readWorkerFactory.getWorkers(operationContext, distribution);
        for (PentoStoreWorker worker : workers) {
            Callable callable = worker.execute(query);
            ListenableFuture future = ioExecutor.submit(callable);

            Futures.addCallback(future, new FutureCallback() {
                public void onSuccess(Object response) {
                    handler.callback(response);

                    // OR
                    // handler.rejection();
                    // handler.error();
                }

                public void onFailure(Throwable thrown) {
                    logger.error(thrown.getMessage());
                    handler.error(thrown);
                }
            });
        }
    }
}
