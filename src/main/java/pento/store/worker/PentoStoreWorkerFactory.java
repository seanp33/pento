package pento.store.worker;

/**
 * Factory interface for producing PentoStoreWorker instances
 */
public interface PentoStoreWorkerFactory<Source, InstanceConfiguration> {

    public PentoStoreWorker<Source> getInstance(InstanceConfiguration instanceConfiguration);

}
