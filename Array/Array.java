package Array;

import java.util.Arrays;

public class Array {
    private int length;
    private int[] array;
    private int currentIndex = 0;

    public Array(int length) {
        this.length = length;
        this.array = new int[length];
    }

    // O(n)
    public void insert(int value) {
        if (this.currentIndex == this.length) {
            int[] newArray = new int[this.length + 1];
            for (int i = 0; i < this.length; i++) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            this.length++;
        }
        this.array[currentIndex] = value;
        this.currentIndex++;

    }

    // O(n)
    public void removeAt(int index) {
        if (index < 0 || index >= this.length) {
            return;
        }
        int[] newArray = new int[this.length - 1]; // 2
        for (int i = 0; i < this.length; i++) { // 3
            if (index != i) {
                newArray[i <= index ? i : (i - 1)] = this.array[i];
            }
        }
        this.array = newArray;
        this.currentIndex--;
        this.length--;
    }

    // O(n)
    public int indexOf(int value) {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println(Arrays.toString(this.array));
    }
}
