package LinkedListDSA;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node head;
    private Node tail;
    public int size = 0;

    public void addFirst(int num) {
        var node = new Node(num);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        size++;

    }

    public void addLast(int num) {
        var node = new Node(num);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;

        }
        size++;
    }

    public int indexOf(int num) {
        int index = 0;
        var current = this.head;
        while (current != null) {
            if (current.value == num) {
                return index;
            } else {
                index++;
                current = current.next;
            }
        }
        return -1;

    }

    public boolean contains(int num) {
        var current = this.head;
        while (current != null) {
            if (current.value == num) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public void removeFirst() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        if (this.head != this.tail) {
            this.head = this.head.next;
        } else {
            this.head = this.tail = null;
        }
        size--;
    }

    public void removeLast() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        if (this.head != this.tail) {
            var current = this.head;
            while (current.next != this.tail) {
                current = current.next;
            }
            this.tail = current;

        } else {
            this.head = this.tail = null;
        }
        size--;
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        if (this.head == null) {
            return array;
        }
        var current = this.head;
        for (int i = 0; i < this.size; i++) {
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {
        if (this.head == this.tail) {
            return;
        }
        var previous = this.head;
        var current = this.head.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.tail = this.head;
        this.tail.next = null;
        this.head = previous;
    }

    public int getKthNodeFromLast(int k) throws Exception {
        if (k < 0 || k > this.size) {
            throw new Exception("Element position out of bound");
        }
        var previous = this.head;
        var current = this.head;

        for (var index = 0; index < (k - 1); index++) {
            current = current.next;

        }

        while (current != this.tail) {
            previous = previous.next;
            current = current.next;
        }
        return previous.value;
    }

    public void printMiddle() {
        if (this.head == null) {
            return;
        }

        var previous = this.head;
        var current = this.head;

        boolean isEven = false;
        while (current != this.tail) {
            if (current.next.next == null) {
                isEven = true;
                break;
            } else {
                previous = previous.next;
                current = current.next.next;
            }
        }
        System.out.println(isEven ? previous.value + "|" + current.value : previous.value);
    }

    // Floyd's Cycle Finding Algorithm
    // To test this, make all the private variables public and write
    /*
     * var list = new LinkedList();
     * list.addLast(10);
     * list.addLast(20);
     * list.addLast(30);
     * list.tail.next = list.head;
     * System.out.println(list.hasLoop());
     */
    public boolean hasLoop() {
        if (this.head == null) {
            return false;
        }
        Node slow_p = this.head;
        Node fast_p = this.head;
        boolean hasLoop = false;
        while (fast_p.next != null) {
            slow_p = slow_p.next;
            if (fast_p.next.next == null) {
                break;
            }
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                hasLoop = true;
                break;
            }
        }
        return hasLoop;

    }
}
