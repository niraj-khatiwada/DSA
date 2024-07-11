package Heaps;

public class IsMaxHeap {
    // Using while loop
    public boolean isMaxHeap(int[] array) {
        if (array.length == 0) {
            return false;
        }
        var lastParentIndex = (array.length / 2) - 1;
        for (var i = lastParentIndex; i >= 0; i--) {
            var c = i;
            while (true) {
                var root = array[i];
                var childIndexes = this._findChildIndexes(i);
                var leftChildIndex = childIndexes[0];
                var rightChildIndex = childIndexes[1];
                var leftChild = leftChildIndex < array.length ? array[leftChildIndex] : null;
                var rightChild = rightChildIndex < array.length ? array[rightChildIndex] : null;

                if (leftChild == null || rightChild == null) {
                    if (leftChild == null) {
                        if (root < rightChild) {
                            return false;
                        }
                    }
                    if (rightChild == null) {
                        if (root < leftChild) {
                            return false;
                        }
                    }
                }
                if (leftChild != null && rightChild != null) {
                    if (root < leftChild || root < rightChild) {
                        return false;
                    }
                }
                c++;
                if (c > (array.length - 1)) {
                    break;
                }
            }
        }
        return true;
    }

    // Using recursion
    public boolean isMaxHeapUsingRecursion(int[] array) {
        if (array.length == 0) {
            return false;
        }
        return this._isMaxHeapUsingRecursion(array, 0);

    }

    private boolean _isMaxHeapUsingRecursion(int[] array, int i) {
        var lastParentIndex = (array.length / 2) - 1;
        if (i > lastParentIndex) {
            return true;
        }
        var childIndexes = this._findChildIndexes(i);
        return this._isValidParent(array, i) && _isMaxHeapUsingRecursion(array, childIndexes[0])
                && _isMaxHeapUsingRecursion(array, childIndexes[1]);

    }

    private boolean _isValidParent(int[] array, int i) {
        if (i < 0 || i > (array.length - 1)) {
            return true;
        }
        var parent = array[i];
        var childIndexes = this._findChildIndexes(i);
        var leftChildIndex = childIndexes[0];
        var rightChildIndex = childIndexes[1];
        var leftChild = leftChildIndex < array.length ? array[leftChildIndex] : null;
        var rightChild = rightChildIndex < array.length ? array[rightChildIndex] : null;

        if (leftChild == null && rightChild == null) {
            return true;
        }
        if (leftChild == null || rightChild == null) {
            if (leftChild == null) {
                if (parent < rightChild) {
                    return false;
                }
            }
            if (rightChild == null) {
                if (parent < leftChild) {
                    return false;
                }
            }
        }
        if (leftChild != null && rightChild != null) {
            if (parent < rightChild || parent < leftChild) {
                return false;
            }
        }
        return true;
    }

    private int[] _findChildIndexes(int index) {
        return new int[] { index * 2 + 1, index * 2 + 2 };
    }
}

// var heap = new IsMaxHeap();
// System.out.println(heap.isMaxHeap(new int[] { 10, 9, 8, 4, 5, 3, 1, 5 }));
// System.out.println(heap.isMaxHeapUsingRecursion(new int[] { 10, 9, 8, 4, 5,
// 3, 1, 5 }));
