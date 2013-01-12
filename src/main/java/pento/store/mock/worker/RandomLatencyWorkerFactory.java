package pento.store.mock.worker;

import pento.model.Distribution;
import pento.store.worker.EmptyContext;
import pento.model.Pento;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyWorker
 */
public class RandomLatencyWorkerFactory implements PentoStoreWorkerFactory<Pento, Distribution, EmptyContext> {

    @Override
    public PentoStoreWorker<Pento, Distribution> getInstance(EmptyContext configuration) {
        return new RandomLatencyWorker();
    }
}
