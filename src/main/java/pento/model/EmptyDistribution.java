package pento.model;

import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of {@link Distribution} having no entries
 */
public class EmptyDistribution implements Distribution<String, Object> {

    @Override
    public void addMember(String key, Object o) {
        throw new IllegalArgumentException("Member's cannot be added to an empty distribution");
    }

    @Override
    public void removeMember(String key) {
        throw new IllegalArgumentException("Member's cannot be removed from an empty distribution");
    }

    @Override
    public boolean hasMember(String key) {
        return false;
    }

    @Override
    public Map<String, Object> getMembers() {
        return new HashMap<String, Object>();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean includesLocal() {
        return false;
    }
}
