package Search;

public class LinearSearch {
    public int find(int[] array, int value) {
        for (var i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
