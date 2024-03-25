package array;

public class Array {
    private int[] array;
    private int currentIndex = -1;

    public Array(int size) {
        this.array = new int[size];
    }

    public int size() {
        return this.array.length;
    }

    // O(n)
    public void add(int item) {
        if ((this.currentIndex + 1) >= this.array.length) {
            int[] arrayReference = this.array;
            this.array = new int[this.array.length + 1];
            for (int i = 0; i < arrayReference.length; i++) {
                this.array[i] = arrayReference[i];
            }
        }
        this.currentIndex += 1;
        this.array[this.currentIndex] = item;

    }

    // O(n)
    public void remove(int index) {
        if (index < 0 || index > (this.array.length - 1)) {
            return;
        }
        int[] newArray = new int[this.array.length - 1];
        for (int i = 0; i < this.array.length; i++) {
            if (i != index) {
                newArray[i <= index ? i : i - 1] = this.array[i];
            }
        }
        this.array = newArray;

    }

    // O(n)
    public int indexOf(int item) {
        int index = -1;

        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == item) {
                index = i;
            }
        }

        return index;
    }

    // O(n)
    public boolean contains(int item) {
        boolean contains = false;
        for (var val : this.array) {
            if (val == item) {
                contains = true;
            }
        }
        return contains;
    }

    // O(n)
    public int max() {
        int max = 0;

        for (var val : this.array) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }

    // O(n^2)
    public int[] intersect(int[] anotherArray) {
        int[] commonItems = new int[Math.min(this.array.length, anotherArray.length)];
        int currentIndex = -1;
        for (int i = 0; i < this.array.length; i++) {
            for (int j = 0; j < anotherArray.length; j++) {
                if (this.array[i] == anotherArray[j]) {
                    currentIndex += 1;
                    commonItems[currentIndex] = this.array[i];
                }
            }
        }
        return commonItems;
    }

    // O(n)
    public int[] reverse() {
        int[] reversed = new int[this.array.length];
        for (int i = 0; i < this.array.length; i++) {
            reversed[i] = this.array[this.array.length - 1 - i];
        }
        return reversed;
    }

    public int[] insertAt(int index, int item) {
        if (index >= this.array.length) {
            var arrayReference = this.array;
            this.array = new int[index + 1];
            for (int i = 0; i < arrayReference.length; i++) {
                this.array[i] = arrayReference[i];
            }
        }
        this.array[index] = item;
        if (index > this.currentIndex) {
            this.currentIndex = index;
        }
        return this.array;
    }

    public int[] getArray() {
        return this.array;
    }
}

// [1, 2, 3, -, -, -]
// [1, -, -]