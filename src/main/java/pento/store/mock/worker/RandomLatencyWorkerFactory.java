package pento.store.mock.worker;

import pento.store.worker.EmptyContext;
import pento.model.Pento;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyWorker
 */
public class RandomLatencyWorkerFactory implements PentoStoreWorkerFactory<Pento, EmptyContext> {

    @Override
    public PentoStoreWorker<Pento> getInstance(EmptyContext configuration) {
        return new RandomLatencyWorker();
    }
}
