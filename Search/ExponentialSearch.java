package Search;

public class ExponentialSearch {
    // O(log(i)) i= index of element
    public int search(int[] array, int num) {
        var l = 0;
        var r = l + 1;
        while (l <= (array.length - 1) && r <= (array.length - 1)) {
            if (array[r] == num) {
                return r;
            } else if (num > array[r]) {
                l = r + 1;
                r = r * 2;
            } else {
                break;
            }
        }
        var search = new BinarySearch();
        return search._search(array, l, r, num);
    }
}
