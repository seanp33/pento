package pento.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple mapping of hosts to {@link Confidence} entries
 */
public class ConfidenceMap {

    Map<String, Confidence> mapping = new HashMap<String, Confidence>();

    public void register(String host, Confidence confidence) {
        mapping.put(host, confidence);
    }

    public void unregister(String host) {
        mapping.remove(host);
    }

    public Confidence getForHost(String host) {
        return mapping.get(host);
    }

    public Map<String, Confidence> getMapping() {
        return Collections.unmodifiableMap(mapping);
    }
}
