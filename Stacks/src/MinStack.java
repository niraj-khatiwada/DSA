public class MinStack {
    private int[] array;
    private int index = -1;

    private int size = 0;

    private int[] minArray;
    private int minIndex = -1;

    public MinStack(int size) {
        this.array = new int[size];
        this.size = size;
        this.minArray = new int[size];
    }

    // O(n)
    public void push(int value) {
        this.index++;
        this.array[this.index] = value;

        // minimum
        if (this.minIndex == -1) {
            this.minIndex++;
            this.minArray[this.minIndex] = value;
        } else {
            int lastMinValue = this.minArray[this.minIndex];
            if (value < lastMinValue) {
                this.minIndex++;
                this.minArray[this.minIndex] = value;
            }
        }
    }

    // O(n)
    public int pop() {
        if (this.index == -1) {
            throw new Error("No item to pop.");
        }
        if (this.index + 1 > this.size) {
            throw new StackOverflowError();
        }
        int popped = this.array[this.index];
        this.index--;

        // minimum
        if (popped == this.minArray[this.minIndex]) {
            this.minIndex--;
        }

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

    public int min() {
        if (this.minIndex == -1) {
            throw new Error("No value in stack.");
        }
        return this.minArray[this.minIndex];
    }

    public int[] toArray() {
        int[] list = new int[this.index + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = this.array[i];
        }
        return list;
    }
}