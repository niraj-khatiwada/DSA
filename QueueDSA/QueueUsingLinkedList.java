package QueueDSA;

public class QueueUsingLinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void enqueue(int item) {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        size++;
    }

    public void dequeue() {
        if (this.head == null) {
            throw new IllegalStateException();
        }
        if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
        }
        size--;
    }

    public int peek() {
        return this.tail.value;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        var current = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

}
