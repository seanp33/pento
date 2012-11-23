package pento.store.mock.worker;

import pento.store.worker.EmptyConfiguration;
import pento.model.Pento;
import pento.store.worker.PentoStoreWorker;
import pento.store.worker.PentoStoreWorkerFactory;

/**
 * PentoStoreWorkerFactory impl for producing new instances of RandomLatencyWorker
 */
public class RandomLatencyWorkerFactory implements PentoStoreWorkerFactory<Pento, EmptyConfiguration> {

    @Override
    public PentoStoreWorker<Pento> getInstance(EmptyConfiguration configuration) {
        return new RandomLatencyWorker();
    }
}
