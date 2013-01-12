package pento.model;

import java.util.Iterator;

public interface Distribution<Member>{

    Iterator<Member> getMembers();

    boolean isEmpty();

    int size();

}