package pento.store.mock;

import pento.model.Pento;
import pento.store.PentoStoreWorker;
import pento.store.PentoStoreWorkerFactory;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyWorker
 */
public class RandomLatencyWorkerFactory implements PentoStoreWorkerFactory<Pento> {

    @Override
    public PentoStoreWorker<Pento> getInstance() {
        return new RandomLatencyWorker();
    }
}
