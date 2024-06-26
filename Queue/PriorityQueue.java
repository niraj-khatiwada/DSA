package Queue;

import java.util.Arrays;

public class PriorityQueue {
    public int[] array;
    public int currentIndex = -1;

    public PriorityQueue(int size) {
        this.array = new int[size];
    }

    public void add(int value) {
        if (this.currentIndex == (this.array.length - 1)) {
            throw new IllegalArgumentException("Out of bound.");
        }
        if (this.currentIndex == -1) {
            this.currentIndex++;
            this.array[this.currentIndex] = value;
            return;
        }
        for (int i = this.currentIndex; i >= 0; i--) {
            var item = this.array[i];
            if (value < item) {
                this.array[i + 1] = this.array[i];
            } else {
                this.array[i + 1] = value;
                break;
            }
            if (i == 0) {
                this.array[i] = value;
            }
        }
        this.currentIndex++;
    }

    public int remove() {
        if (this.currentIndex == -1) {
            throw new IllegalArgumentException("No items to remove.");
        }
        int[] newArray = new int[this.array.length];
        var i = 0;
        while (i < this.currentIndex) {
            newArray[i] = this.array[i + 1];
            i++;
        }
        var value = this.array[0];
        this.array = newArray;
        this.currentIndex--;
        return value;
    }

    public void print() {
        int[] newArray = new int[this.currentIndex + 1];
        var i = 0;
        while (i <= this.currentIndex) {
            newArray[i] = this.array[i];
            i++;
        }
        System.out.println(Arrays.toString(newArray));
    }

}
