package pento.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of {@link Distribution} having no entries
 */
public class EmptyDistribution implements Distribution<Object> {

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
    public Iterable<Object> getMembers() {
        return new ArrayList<Object>();
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
