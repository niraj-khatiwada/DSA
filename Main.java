import java.util.ArrayList;

import array.Array;

class Main {
    public static void main(String[] args) {

        Array list = new Array(3);
        list.add(1);
        list.add(2);
        list.add(21);
        list.max();

        var val = list.insertAt(0, 100);
        var val2 = list.insertAt(5, 500);
        list.add(10);

        // ArrayList<Integer> array = new ArrayList<>();
        // array.add(1);
        // array.add(2);
        // array.add(3);

        // array.remove(2);

        // System.out.println(array.indexOf(2));
        // System.out.println(array.size());
        // System.out.println(array.contains(100));

        // for (var val : array) {
        // System.out.printf("%s = %s\n", array.indexOf(val), val);
    }

}
