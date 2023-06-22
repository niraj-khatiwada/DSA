package HashTables;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;

    public HashTable(int size) {
        table = new LinkedList[size];
    }

    public void put(int key, String value) {
        Entry newEntry = new Entry(key, value);
        int index = this.hash(key);
        if (this.table[index] == null) {
            LinkedList<Entry> list = new LinkedList<Entry>();
            list.addLast(newEntry);
            this.table[index] = list;
        } else {
            for (int i = 0; i < this.table[index].size(); i++) {
                Entry listEntry = this.table[index].get(i);
                if (listEntry.key == key) {
                    listEntry.value = value;
                    return;
                }
            }
            this.table[index].add(newEntry);
        }
    }

    public String get(int key) {
        String returnValue = null;
        int index = this.hash(key);
        LinkedList<Entry> indexList = this.table[index];
        for (Entry entry : indexList) {
            if (entry.key == key) {
                returnValue = entry.value;
                break;
            }
        }
        return returnValue;
    }

    public void remove(int key) {
        int index = this.hash(key);
        LinkedList<Entry> listItem = this.table[index];
        if (listItem == null) {
            throw new IllegalStateException();
        }
        for (var entry : listItem) {
            if (entry.key == key) {
                listItem.remove(entry);
                return;
            }
        }
        throw new IllegalArgumentException();

    }

    public boolean contains(int key) {
        int index = this.hash(key);
        LinkedList<Entry> listItem = this.table[index];
        if (listItem == null) {
            return false;
        }
        for (var entry : listItem) {
            if (entry.key == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % this.table.length;
    }

}
