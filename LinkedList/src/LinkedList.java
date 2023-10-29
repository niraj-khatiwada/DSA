import java.util.ArrayList;

public class LinkedList {
    public Node head;
    public Node tail;

    public int size() {
        int length = 0;
        Node node = this.head;

        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    // 0(1)
    public void addFirst(int value) {
        if (this.head == null && this.tail == null) {
            this.head = this.tail = new Node(value);
            return;
        }
        if (this.head == this.tail) {
            Node newNode = new Node(value);
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    // O(1)
    public void addLast(int value) {
        if (this.head == null && this.tail == null) {
            this.head = this.tail = new Node(value);
            return;
        }
        if (this.head == this.tail) {
            this.tail = new Node(value);
            this.head.next = this.tail;
            return;
        }

        this.tail.next = new Node(value);
        this.tail = this.tail.next;
    }

    // O(1)
    public void deleteFirst() {
        if (this.tail == null && this.head == null) {
            throw new Error("No nodes to delete.");
        }

        if (this.tail == this.head) {
            this.tail = this.head = null;
            return;
        }

        this.head = this.head.next;
    }


    // O(n)
    public void deleteLast() {
        if (this.tail == null && this.head == null) {
            throw new Error("No nodes to delete.");
        }
        if (this.tail == this.head) {
            this.tail = this.head = null;
            return;
        }

        Node node = this.head;
        while (true) {
            if (node.next == this.tail) {
                break;
            }
            node = node.next;
        }
        node.next = null;
        this.tail = node;

    }


    // O(n)
    public boolean contains(int value) {
        boolean hasValue = false;
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                hasValue = true;
                break;
            }
            node = node.next;
        }

        return hasValue;
    }

    // O(n)
    public int indexOf(int value) {
        int index = -1;
        boolean contains = false;
        Node node = this.head;
        while (node != null) {
            if (node.value == value) {
                index++;
                contains = true;
                break;
            } else {
                index++;
                node = node.next;
            }
        }
        return contains ? index : -1;
    }

    public void reverse() {
        if (this.head == null || this.head == this.tail) {
            return;
        }

        Node previous = this.head;
        Node current = this.head.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.tail = this.head;
        this.tail.next = null;
        this.head = previous;
    }

    public int findKthNodeFromEnd(int k) {
        Node pointer1 = this.head;
        Node pointer2 = this.head;

        for (int i = 0; i < k - 1; i++) {
            if (pointer2.next == null) {
                throw new Error(String.format("%s is not a valid range", k));
            }
            pointer2 = pointer2.next;
        }

        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1.value;
    }

    public int[] toArray() {
        ArrayList<Integer> array = new ArrayList<>();

        Node node = this.head;
        while (node != null) {
            array.add(node.value);
            node = node.next;
        }
        int[] list = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            list[i] = array.get(i);
        }
        return list;
    }
}
