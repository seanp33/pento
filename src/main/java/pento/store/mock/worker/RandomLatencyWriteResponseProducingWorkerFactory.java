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
public class RandomLatencyWriteResponseProducingWorkerFactory implements PentoStoreWorkerFactory<Pento, EmptyContext, Object> {

    @Override
    public List<PentoStoreWorker<Pento>> getWorkers(EmptyContext configuration, Distribution<Object> distribution) {
        ArrayList<PentoStoreWorker<Pento>> workers = new ArrayList<PentoStoreWorker<Pento>>();
        workers.add(new RandomLatencyWriteResponseProducingWorker());
        return workers;
    }
}
