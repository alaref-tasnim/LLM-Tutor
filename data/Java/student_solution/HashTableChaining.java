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
        if (value == null) {
            throw new NullPointerException("value must not be null");
        }
        int h = hashValue(key);
        ArrayList<HashEntry<K,V>> l = this.array[h];
        if (l == null) {
            l = new ArrayList<>();
            HashEntry<K, V> entry = new HashEntry<>(key, value);
            l.add(entry);
            
        } else {
            for (HashEntry<K,V> e : l) {
                if (e.getKey() == key) {
                    e.setValue(value);
                    
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
        
         
        for (HashEntry<K,V> entry : l) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
            }
        }
        return null;
    }
    

    @Override
    public void remove(K key) {
        int h = hashValue(key);
        ArrayList<HashEntry<K,V>> l = this.array[3];
        if (l != null) {
            for (HashEntry<K,V> e : l) {
                if (e.getKey().equals(key)) {
                    l.remove(e);

                }
            }
        }
    }

    @Override
    public int size() {
        for (ArrayList<HashEntry<K,V>> l : this.array) {
            if (l != null) {
                return l.size();
            }
        }

    }




}
