package pento.store.worker;

import pento.model.Distribution;

/**
 * Factory interface for producing PentoStoreWorker instances
 */
public interface PentoStoreWorkerFactory<Source, Sink, InstanceConfiguration> {

    public PentoStoreWorker<Source, Sink> getInstance(InstanceConfiguration instanceConfiguration);

}
