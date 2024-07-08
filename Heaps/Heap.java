package Heaps;

public class Heap {
    private int[] heap;
    private int currentIndex = -1;

    public Heap(int size) {
        this.heap = new int[size];
    }

    public void insert(int value) {
        if ((this.currentIndex + 1) >= this.heap.length) {
            throw new IllegalStateException("Heap is full.");
        }
        this.currentIndex++;
        this.heap[this.currentIndex] = value;
        this._bubbleUp();

    }

    public int remove() {
        if (this.currentIndex < 0) {
            throw new IllegalStateException("Heap is empty.");
        }
        var deleted = this.heap[0];
        this.heap[0] = this.heap[this.currentIndex];
        this.heap[this.currentIndex] = 0;
        this.currentIndex--;
        this._bubbleDown();
        return deleted;
    }

    public int size() {
        return this.currentIndex + 1;
    }

    private void _bubbleUp() {
        var c = this.currentIndex;
        var value = this.heap[c];
        while (true) {
            var parentIndex = this._findParentIndex(c);
            var parent = this.heap[parentIndex];
            if (value > parent) {
                this._swap(parentIndex, c);
                c = parentIndex;
            } else {
                break;
            }
        }
    }

    private void _bubbleDown() {
        var c = 0;
        while (true) {
            var value = this.heap[c];
            // Child indexes can be out of bounds
            var leftChildIndex = this._findLeftChildIndex(c);
            var rightChildIndex = this._findRightChildIndex(c);
            var leftChild = leftChildIndex <= this.heap.length ? this.heap[leftChildIndex] : null;
            var rightChild = leftChildIndex <= this.heap.length ? this.heap[rightChildIndex] : null;

            if (leftChild == null && rightChild == null) {
                break;
            }

            if (leftChild == null || rightChild == null) {
                if (leftChild == null) {
                    if (value < rightChild) {
                        this._swap(rightChildIndex, c);
                    }
                }
                if (rightChild == null) {
                    if (value < leftChild) {
                        this._swap(leftChildIndex, c);
                    }
                }
            } else {
                if (value < leftChild || value < rightChild) {
                    this._swap(leftChild > rightChild ? leftChildIndex : rightChildIndex, c);
                } else {
                    break;
                }
            }
            c++;
            if (c > this.currentIndex) {
                break;
            }
        }
    }

    private int _findParentIndex(int index) {
        if (index == 0) {
            return 0;
        }
        // since we're converting to int, 1/2 will resolve to 0 which is correct parent
        // index.
        return (index - 1) / 2;
    }

    private int _findLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int _findRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void _swap(int i, int j) {
        var value = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = value;
    }
}
