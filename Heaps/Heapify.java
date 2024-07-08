package Heaps;

// In Heap, we did bubble down on remove().
// In heapify, basically we're given the complete array already. We just need to bubble down comparing the parent to its children.
// It's same as remove() in heap but we need to bubble down for each parent node. In remove(), we just bubbled down the first node that was placed after removing.
public class Heapify {

    public int[] heapify(int[] array) {
        for (var i = 0; i < array.length; i++) {
            var currentIndex = i;
            while (true) {
                var value = array[currentIndex];
                var childIndexes = this._findChildIndexes(currentIndex);
                var leftChildIndex = childIndexes[0];
                var rightChildIndex = childIndexes[1];
                var leftChild = leftChildIndex <= (array.length - 1) ? array[leftChildIndex] : null;
                var rightChild = rightChildIndex <= (array.length - 1) ? array[rightChildIndex] : null;
                if (leftChild == null && rightChild == null) {
                    break;
                }
                if (leftChild == null || rightChild == null) {
                    if (leftChild == null) {
                        if (value < rightChild) {
                            array = this._swap(array, rightChildIndex, currentIndex);
                        } else {
                            break;
                        }
                    }
                    if (rightChild == null) {
                        if (value < leftChild) {
                            array = this._swap(array, leftChildIndex, currentIndex);
                        } else {
                            break;
                        }
                    }
                } else {
                    if (value < leftChild || value < rightChild) {
                        array = this._swap(array, leftChild > rightChild ? leftChildIndex : rightChildIndex,
                                currentIndex);
                    } else {
                        break;
                    }
                }
                currentIndex++;
                if (currentIndex > (array.length - 1)) {
                    break;
                }
            }
        }
        return array;
    }

    private int[] _findChildIndexes(int index) {
        var leftChildIndex = index * 2 + 1;
        var rightChildIndex = index * 2 + 2;
        return new int[] { leftChildIndex, rightChildIndex };
    }

    private int[] _swap(int[] array, int i, int j) {
        var ref = array[i];
        array[i] = array[j];
        array[j] = ref;
        return array;
    }
}

// var heap = new Heapify();
// var heapify = heap.heapify(new int[] { 5, 3, 8, 4, 1, 2 });
// System.out.println(Arrays.toString(heapify));
