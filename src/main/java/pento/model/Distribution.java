package pento.model;

public interface Distribution<V>{

    void addMember(String key, V member);

    void removeMember(String key);

    boolean hasMember(String key);

    Iterable<V> getMembers();

    boolean isEmpty();

    boolean includesLocal();

    int size();

}