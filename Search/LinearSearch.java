package Search;

public class LinearSearch {
    // O(n)
    // O(1) in best case.
    public int search(int[] array, int a) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return i;
            }
        }
        return -1;
    }
}
