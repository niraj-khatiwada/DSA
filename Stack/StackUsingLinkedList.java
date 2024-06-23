package Stack;

import java.util.Arrays;

// You need to create raw LinkedList instead of using built in LinkedIn Class.
public class StackUsingLinkedList {
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

    // Push basically is addLast in LinkedList implementation.
    // (See LinkedList folder)
    public void push(int value) {
        size++;
        var node = new Node(value);
        if (this.head == null) {
            this.head = this.tail = node;
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

    // Pop is removeLast()
    public int pop() {
        if (this.head == null) {
            throw new IllegalArgumentException("No item to pop.");
        }
        this.size--;
        if (this.head == this.tail) {
            int value = this.head.value;
            this.head = this.tail = null;
            return value;
        }
        var currentNode = this.head;
        while (currentNode.next != this.tail) {
            currentNode = currentNode.next;
        }
        int value = this.tail.value;
        this.tail = currentNode;
        return value;

    }

    public int peek() {
        if (this.head == null) {
            throw new IllegalArgumentException("No item to peek.");
        }
        return this.tail.value;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void print() {
        int[] array = new int[this.size];
        var currentNode = this.head;
        for (var i = 0; i < this.size; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        System.out.println(Arrays.toString(array));
    }

}
