package pento.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of {@link Distribution} having no entries
 */
public class EmptyDistribution implements Distribution<Object> {

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
