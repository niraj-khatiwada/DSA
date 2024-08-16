package Search;

public class JumpSearch {
    // O(Math.sqrt(n))
    public int search(int[] array, int num) {
        var bucketSize = (int) Math.sqrt(num);
        var l = 0;
        var r = bucketSize - 1;
        while (l < r && r <= (array.length - 1)) {
            if (array[r] == num) {
                return r;
            } else if (num > array[r]) {
                l = r + 1;
                r += bucketSize;
            } else {
                break;
            }
        }
        if (l >= (array.length)) {
            return -1;
        }
        for (var i = l; i <= r; i++) {
            if (i >= array.length) {
                return -1;
            }
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

}
