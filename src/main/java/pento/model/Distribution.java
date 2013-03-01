package pento.model;

import java.util.Iterator;

public interface Distribution<Member>{

    Iterable<Member> getMembers();

    boolean isEmpty();

    boolean includesLocal();

    int size();

}