package pento.model;

import com.google.common.collect.Multimap;

import java.util.Map;

public interface Distribution<K, V>{

    void addMember(K key, V member);

    void removeMember(K key);

    boolean hasMember(K key);

    Map<K, V> getMembers();

    boolean isEmpty();

    boolean includesLocal();

    int size();

}