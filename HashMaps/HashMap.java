package HashMaps;

import java.util.LinkedList;

public class HashMap {

    private static class KeyValuePair {
        public int key;
        public String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<KeyValuePair>[] list;
    int count = 0;

    public HashMap(int size) {
        list = new LinkedList[size];
    }

    public void put(int key, String value) {
        if (this.count >= this.list.length) {
            throw new Error("Out of range.");
        }
        KeyValuePair entry = new KeyValuePair(key, value);
        int index = hash(key);
        System.out.println(this.list[index]);
        if (this.list[index] == null) {
            LinkedList<KeyValuePair> ll = new LinkedList<>();
            ll.add(entry);
            this.list[index] = ll;
        } else {
            LinkedList<KeyValuePair> ll = this.list[index];
            ll.add(entry);
            this.list[index] = ll;
        }
        this.count++;
    }

    public String get(int key) {
        int index = hash(key);
        String result = "";
        LinkedList<KeyValuePair> ll = this.list[index];
        if (ll == null) {
            return result;
        }
        if (ll.size() > 1) {
            for (int i = 0; i < ll.size(); i++) {
                KeyValuePair entry = ll.get(i);
                if (entry.key == key) {
                    result = entry.value;
                    break;
                }
            }
        } else if (ll.size() == 1) {
            KeyValuePair entry = ll.get(0);
            if (entry.key == key) {
                return ll.get(0).value;
            }
        }
        return result;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<KeyValuePair> ll = this.list[index];
        if (ll == null) {
            return;
        }
        if (ll.size() > 1) {
            for (int i = 0; i < ll.size(); i++) {
                KeyValuePair entry = ll.get(i);
                if (entry.key == key) {
                    ll.remove(i);
                    this.list[index] = ll;
                    break;
                }
            }
        } else if (ll.size() == 1) {
            KeyValuePair entry = ll.get(0);
            if (entry.key == key) {
                this.list[index] = new LinkedList<>();
            }
        }
    }

    public int size() {
        return this.count;
    }

    private int hash(int key) {
        return Math.abs(key % 5);
    }

}