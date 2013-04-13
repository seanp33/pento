package pento.store.mock.worker;

import pento.model.Distribution;
import pento.op.PentoQuery;
import pento.store.worker.EmptyContext;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyReadResponseProducingWorker
 */
public class RandomLatencyReadResponseProducingWorkerFactory implements PentoStoreWorkerFactory<PentoQuery, EmptyContext, Object, Object> {

    @Override
    public List<PentoStoreWorker<Object, PentoQuery>> getWorkers(EmptyContext configuration, Distribution<Object, Object> distribution) {
        ArrayList<PentoStoreWorker<Object, PentoQuery>> workers = new ArrayList<PentoStoreWorker<Object, PentoQuery>>();
        workers.add(new RandomLatencyReadResponseProducingWorker());
        return workers;
    }
}
