public class Stack {
    private int[] array;
    private int index = -1;

    public Stack(int size) {
        this.array = new int[size];
    }

    // O(n)
    public void push(int value) {
        this.array[this.index + 1] = value;
        this.index++;

    }

    // O(n)
    public int pop() {
        if (this.index == -1) {
            throw new Error("No item to pop.");
        }
        if (this.index + 1 > this.array.length) {
            throw new StackOverflowError();
        }
        int popped = this.array[this.index];
        this.index--;
        return popped;
    }

    // O(n)
    public int peek() {
        if (this.index == -1) {
            throw new Error("No item to peek.");
        }
        return this.array[this.index];
    }

    // O(n)
    public boolean isEmpty() {
        return this.index == -1;
    }

    public int[] toArray() {
        int[] list = new int[this.index + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = this.array[i];
        }
        return list;
    }
}