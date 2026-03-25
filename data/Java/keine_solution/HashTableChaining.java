package de.hso.aud.ex10_02;

import java.util.ArrayList;

public class HashTableChaining<K, V> implements HashTable<K,V> {

    private static final int SIZE = 97;

    private ArrayList<HashEntry<K,V>>[] array;

    @SuppressWarnings("unchecked")
    public HashTableChaining() {
        this.array = new ArrayList[SIZE];
    }

    @Override
    public void insert(K key, V value) {
        // FIXME: Praktikum
    }

    private int hashValue(K k) {
        int hc = k.hashCode();           // Hashcode
        int h = Math.abs(hc) % SIZE;       // Hashwert, Index im Array
        return h;
    }

    @Override
    public V lookup(K key) {
        return null; // FIXME: Praktikum
    }

    @Override
    public void remove(K key) {
        // FIXME: Praktikum
    }

    @Override
    public int size() {
        return 0; // FIXME: Praktikum
    }
}
