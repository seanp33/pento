package pento.model;

public interface Distribution<Member>{

    Iterable<Member> getMembers();

    boolean isEmpty();

    boolean includesLocal();

    int size();

}