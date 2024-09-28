package Search;

public class BinarySearch {
    // Lower Bound = Smallest index where array[i] >= x
    // If no value is found, return the length of array
    // O(log(n))
    public int lowerBound(int[] array, int x) {
        var l = 0;
        var r = array.length - 1;
        var rs = array.length;
        while (l <= r) {
            var m = (l + r) / 2;
            if (array[m] >= x) {
                r = m - 1;
                rs = m;
            } else {
                l = m + 1;
            }
        }
        return rs;
    }

    // Upper Bound = Smallest index where array[i] > x
    // If no value is found, return the length of array
    // O(log(n))
    public int upperBound(int[] array, int x) {
        var l = 0;
        var r = array.length - 1;
        var rs = array.length;
        while (l <= r) {
            var m = (l + r) / 2;
            if (array[m] > x) {
                r = m - 1;
                rs = m;
            } else {
                l = m + 1;
            }
        }
        return rs;
    }
}
