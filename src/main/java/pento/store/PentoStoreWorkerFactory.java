package pento.store;

/**
 * Factory interface for producing PentoStoreWorker instances
 */
public interface PentoStoreWorkerFactory<Source> {

    public PentoStoreWorker<Source> getInstance();
}
