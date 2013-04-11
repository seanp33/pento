package pento.store.mock.worker;

import pento.model.Distribution;
import pento.model.Pento;
import pento.store.worker.EmptyContext;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyWriteResponseProducingWorker
 */
public class RandomLatencyWriteResponseProducingWorkerFactory implements PentoStoreWorkerFactory<Pento, EmptyContext, Object, Object> {

    @Override
    public List<PentoStoreWorker<Object, Pento>> getWorkers(EmptyContext configuration, Distribution<Object, Object> distribution) {
        ArrayList<PentoStoreWorker<Object, Pento>> workers = new ArrayList<PentoStoreWorker<Object, Pento>>();
        workers.add(new RandomLatencyWriteResponseProducingWorker());
        return workers;
    }
}
