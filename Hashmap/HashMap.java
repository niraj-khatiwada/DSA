package Hashmap;

import java.util.LinkedList;

public class HashMap {
    private class Entry {
        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] array;
    private int size;

    public HashMap(int size) {
        this.array = new LinkedList[size];
        for (var i = 0; i < size; i++) {
            this.array[i] = new LinkedList<>();
        }
    }

    public void put(int key, String value) {
        var newEntry = new Entry(key, value);
        var index = this.getHash(key);
        var currentList = this.array[index];
        if (currentList == null) {
            return;
        }

        if (currentList.size() == 0) {
            var l = new LinkedList<Entry>();
            l.add(newEntry);
            this.array[index] = l;
            size++;
            return;
        }
        for (var entry : currentList) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        size++;
        currentList.add(newEntry);
    }

    public void remove(int key) {
        var index = this.getHash(key);
        var currentList = this.array[index];

        for (var entry : currentList) {
            if (entry.key == key) {
                currentList.remove(entry);
                size--;
                return;
            }
        }

    }

    public String get(int key) {
        var index = this.getHash(key);
        var currentList = this.array[index];

        for (var item : currentList) {
            if (item.key == key) {
                return item.value;
            }
        }
        return null;
    }

    public boolean containsKey(int key) {
        var index = this.getHash(key);
        var currentList = this.array[index];

        for (var item : currentList) {
            if (item.key == key) {
                return true;
            }
        }

        return false;

    }

    public int size() {
        return this.size;
    }

    private int getHash(int key) {
        return key % (this.array.length);
    }
}
