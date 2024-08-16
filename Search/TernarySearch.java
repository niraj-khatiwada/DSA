package Search;

public class TernarySearch {
    // log base 3(n)
    public int search(int[] array, int num) {
        return this._search(array, 0, array.length - 1, num);
    }

    public int _search(int[] array, int l, int r, int num) {
        if (l > r) {
            return -1;
        }
        var size = (r - l) / 3;
        var m1 = l + size;
        var m2 = r - size;

        if (array[m1] == num) {
            return m1;
        }

        if (array[m2] == num) {
            return m2;
        }

        if (num >= array[l] && num < array[m1]) {
            var rs = _search(array, l, m1 - 1, num);
            if (rs != -1) {
                return rs;
            }
        } else if (num > array[m1] && num < array[m2]) {
            var rs = _search(array, m1 + 1, m2 - 1, num);
            if (rs != -1) {
                return rs;
            }
        } else if (num > array[m2] && num <= array[r]) {
            var rs = _search(array, m2 + 1, r, num);
            if (rs != -1) {
                return rs;
            }
        }

        return -1;

    }
}
