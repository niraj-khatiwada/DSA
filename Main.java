import Hashmap.TwoSum;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        var map = new TwoSum();
        int[] array = { 2, 11, 15, 7 };
        System.out.println(Arrays.toString(map.find(array, 26)));
    }
}
