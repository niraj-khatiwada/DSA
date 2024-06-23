package LinkedList;

public class LinkedList {
    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    private int size;

    // O(1)
    public void addLast(int value) {
        this.size++;
        var node = new Node(value);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        if (this.head == this.tail) {
            this.tail = node;
            this.head.next = this.tail;
            return;
        }
        this.tail.next = node;
        this.tail = node;
        this.tail.next = null;
    }

    public void add(int value) {
        this.addLast(value);
    }

    // O(1)
    public void addFirst(int value) {
        this.size++;
        var node = new Node(value);
        if (this.head == null && this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        if (this.head == this.tail) {
            this.head = node;
            this.head.next = this.tail;
            return;
        }
        var currentHead = this.head;
        this.head = node;
        this.head.next = currentHead;

    }

    // O(1)
    public void deleteFirst() {
        if (this.head == null && this.tail == null) {
            return;
        }
        this.size--;
        if (this.head == this.tail) {
            this.head = this.tail = null;
            return;
        }
        this.head = this.head.next;

    }

    // O(n)
    public void deleteLast() {
        if (this.head == null && this.tail == null) {
            return;
        }
        this.size--;
        if (this.head == this.tail) {
            this.head = this.tail = null;
            return;
        }
        var currentNode = this.head;
        while (currentNode.next != this.tail) {
            currentNode = currentNode.next;
        }
        this.tail = currentNode;
    }

    // O(n)
    public boolean contains(int value) {
        var currentNode = this.head;
        while (currentNode.next != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // O(n)
    public int indexOf(int value) {
        if (this.head == null) {
            return -1;
        }
        var currentNode = this.head;
        var currentIndex = 0;
        while (currentNode.next != null) {
            if (currentNode.value == value) {
                return currentIndex;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }
        return -1;
    }

    // O(1)
    public int size() {
        return this.size;
    }

    // O(1)
    public boolean isEmpty() {
        return this.size == 0;
    }

    // O(n)
    public int[] toArray() {
        int[] array = new int[this.size];
        var currentNode = this.head;
        int currentIndex = 0;
        while (currentNode != null) {
            array[currentIndex] = currentNode.value;
            currentIndex++;
            currentNode = currentNode.next;
        }
        return array;
    }

    // O(n)
    public void reverse() {
        if (this.head == null || (this.head == this.tail)) {
            return;
        }
        var previousNode = this.head;
        var currentNode = this.head.next;
        while (currentNode != null) {
            var nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.tail = this.head;
        this.tail.next = null;
        this.head = previousNode;

    }

    // O(n)
    public int kthNodeFromEnd(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("Invalid value for k.");
        }
        var previousNode = this.head;
        var currentNode = this.head;
        for (var i = 0; i < (k - 1); i++) {
            currentNode = currentNode.next;
        }
        while (currentNode.next != null) {
            previousNode = previousNode.next;
            currentNode = currentNode.next;
        }
        return previousNode.value;
    }

    // O(n)
    public void printMiddle() {
        var previousNode = this.head;
        var currentNode = this.head;

        var isEven = false;
        while (currentNode.next != null) {
            if (currentNode.next == this.tail) {
                isEven = true;
                break;
            }
            previousNode = previousNode.next;
            currentNode = currentNode.next.next;
        }
        System.out.printf("%s %s\n", previousNode.value, isEven ? currentNode.value : "");
    }

}
