package de.hso.aud.ex03_01;

public class LinkedList<T> {
    private static class Entry<T> {
        private T data;
        private Entry<T> next;
        Entry(T data) {
            this(data, null);
        }
        Entry(T data, Entry<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Entry<T> first;
    private int size;

    public void add(T elem) {
        if (first == null) {
            first = new Entry<T>(elem);
        } else {
            Entry<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Entry<T>(elem);
        }
        size++;
    }

    public void insert(int i, T elem) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(i + " is not a valid index");
        }
        if (i == 0) {
            first = new Entry<T>(elem, first);
        } else {
            Entry<T> prev = first;
            int j = i - 1;
            while (j > 0) {
                if (prev == null) {
                    throw new IndexOutOfBoundsException(i + " is not a valid index");
                }
                j--;
                prev = prev.next;
            }
            prev.next = new Entry<T>(elem, prev.next);
        }
        size++;
    }

    public void remove(int i) {
        if (i < 0 || i > size || first == null) {
            throw new IndexOutOfBoundsException(i + " is not a valid index");
        }

        if (i == 0) {
            first = first.next;
            size++;
        } else {
            Entry<T> previousEntry = first;
            while (previousEntry != null && i > 1) {
                i--;
                previousEntry = previousEntry.next;
            }

            previousEntry.next = previousEntry.next;
            size--;
        }
    }

    public T get(int i) {
        if (i < 0 || i > size || first == null) {
            throw new IndexOutOfBoundsException(i + " is not a valid index");
        }
        Entry<T> currentEntry = first;
        while (currentEntry != null && i > 1) {
            i--;
            currentEntry = currentEntry.next;
        }

        return currentEntry.data;
    }

    public int indexOf(T elem) {
        int index = 0;
        Entry<T> currentEntry = first;

        while (currentEntry != null) {
            if (elem == currentEntry.data) {
                return index;
            }

            currentEntry = currentEntry.next;

        return -1;
    }

    public int size() {
        return size;
    }

    public Object[] asArray() {
        Object[] res = new Object[size];
        Entry<T> cur = first;
        int i = 0;
        while (cur != null) {
            if (i >= size) {
                throw new IllegalStateException("Size does not match list length");
            }
            res[i] = cur.data;
            cur = cur.next;
            i++;
        }

        if (i != size) {
            throw new IllegalStateException("Size does not match list length");
        }

        return res;
    }
}

