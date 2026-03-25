package de.hso.aud.ex10_02;

import java.util.ArrayList;

public class HashTableChaining<K, V> implements HashTable<K,V> {

    private static final int SIZE = 97;

    private ArrayList<HashEntry<K,V>>[] array;

    public HashTableChaining() {
        this.array = new ArrayList[SIZE];
    }

    @Override
    public void insert(K key, V value) {
        if (value == null) {
            throw new NullPointerException("value must not be null");
        }
        int h = hashValue(key);
        ArrayList<HashEntry<K,V>> l = this.array[h];
        if (l == null) {
            // Noch keine Liste im Array
            l = new ArrayList<>();
            HashEntry<K, V> entry = new HashEntry<>(key, value);
            l.add(entry);
            this.array[h] = l;
        } else {
            for (HashEntry<K,V> entryInList : l) {
                if (entryInList.getKey().equals(key)) {
                    entryInList.setValue(value);
                    return;
                }
            }
            HashEntry<K, V> entry = new HashEntry<>(key, value);
            l.add(0, entry);
        }
    }

    private int hashValue(K k) {
        int hc = k.hashCode();           // Hashcode
        int h = Math.abs(hc) % SIZE;       // Hashwert, Index im Array
        return h;
    }

    @Override
    public V lookup(K key) {
        int h = hashValue(key);
        ArrayList<HashEntry<K,V>> l = this.array[h];
        if (l == null) {
            return null;
        } else {
            for (HashEntry<K,V> entryInList : l) {
                if (entryInList.getKey().equals(key)) {
                    return entryInList.getValue();
                }
            }
            return null;
        }
    }

    @Override
    public void remove(K key) {
        int h = hashValue(key);
        ArrayList<HashEntry<K,V>> l = this.array[h];
        if (l != null) {
            // Variant 1: for-loop
            for (HashEntry<K,V> entryInList : l) {
                if (entryInList.getKey().equals(key)) {
                    l.remove(entryInList);
                    return;
                }
            }

            // Variant 2: lambda expression
            // l.removeIf(entry -> entry.getKey().equals(key));
        }
    }

    @Override
    public int size() {
        // Variant 1: for-loop
        int size = 0;
        for (ArrayList<HashEntry<K,V>> l : this.array) {
            if (l != null) {
                size += l.size();
            }
        }

        return size;

        // Variant 2: lambda expression
//		return Arrays.stream(this.array).filter(l -> l != null).mapToInt(l -> l.size()).sum();
    }
}
