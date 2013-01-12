package pento.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of {@link Distribution} having no entries
 */
public class EmptyDistribution implements Distribution<Object> {

    @Override
    public Iterator<Object> getMembers() {
        return new ArrayList<Object>().iterator();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }
}
