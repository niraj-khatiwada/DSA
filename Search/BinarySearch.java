package Search;

public class BinarySearch {
    // O(log(n))
    public int search(int[] array, int num) {
        return this._search(array, 0, array.length - 1, num);
    }

    public int _search(int[] array, int l, int r, int num) {
        if (l > r) {
            return -1;
        }
        var m = (l + r) / 2;
        if (array[m] == num) {
            return m;
        }
        if (m == 0) {
            return -1;
        }

        if (num > array[m]) {
            var rs = _search(array, m + 1, array.length - 1, num);
            if (rs != -1) {
                return rs;
            }
        } else {
            var rs = _search(array, 0, m - 1, num);
            if (rs != -1) {
                return rs;
            }
        }
        return -1;
    }
}
