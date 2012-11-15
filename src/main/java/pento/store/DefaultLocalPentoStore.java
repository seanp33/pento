package pento.store;

import pento.model.Confidence;
import pento.model.ConfidenceMap;

/**
 * A default implementation of PentoStore which provides a default {@link pento.model.Confidence} mapping of
 * local:LOCAL and all remote hosts:UNIVERSAL
 */
public abstract class DefaultLocalPentoStore implements PentoStore{

    protected ConfidenceMap confidenceMap;

    protected DefaultLocalPentoStore() {
        confidenceMap = new ConfidenceMap();
        confidenceMap.register("local", Confidence.LOCAL);
    }

    public ConfidenceMap getConfidenceMap() {
        return confidenceMap;
    }
}
