package pento.store.worker;

import pento.model.Distribution;

import java.util.List;

/**
 * Factory interface for producing PentoStoreWorker instances
 */
public interface PentoStoreWorkerFactory<Source, InstanceConfiguration, Member, Endpoint> {

    public List<PentoStoreWorker<Source>> getWorkers(InstanceConfiguration instanceConfiguration, Distribution<Member, Endpoint> distribution);

}
