package pento.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple mapping of hosts to {@link Confidence} entries
 */
public class ConfidenceRegistry {

    private static final Map<String, Confidence> mapping = new HashMap<String, Confidence>();

    public static void register(String host, Confidence confidence) {
        mapping.put(host, confidence);
    }

    public static void unregister(String host) {
        mapping.remove(host);
    }

    public static Confidence getForHost(String host) {
        return mapping.get(host);
    }

    public static Map<String, Confidence> getMapping() {
        return Collections.unmodifiableMap(mapping);
    }
}
