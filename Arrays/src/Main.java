import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // An integer takes 4 bytes of memory in Java
        // Arrays in Java are fixed length ahead of time. If you want to mak a dynamic array, the run time complexity to resize the array to make it dynamic will be o(n) because you have to copy all the entries from original array to new array.
//        int[] array = {1, 2, 3};
//        System.out.println(itemLookupByIndex(array,1)); // Time complexity is always O(1)

//        int[] array2 = new int[3];
//        array2[0] = 1;
//        array2[1] = 2;
//        array2[2] = 3;
//        System.out.println(Arrays.toString(array2));

        /*
            Adding an item to the array
            Since you have to copy the original array to new array and add it, this will be 0(n)
        */

        /*
            Removing an item from the array
            If the item is in the last, the resize is not required. So this is the best case for deleting an item on an array with time complexity O(n)
            But, if the item is in the first place, you have to remove and shift alk the entries to one unit on left. This is the worst case scenario with time complexity is O(n)
            That's why LinkedList are better at delete operation.
        */

        Array list = new Array();
        list.insert(100);
        list.insert(200);
        list.insert(300);
//        list.insert(400);
//        System.out.println(list.length);
//        System.out.println(Arrays.toString(list.reverse()));
        list.insertAt(0, 500);
        list.printToConsole();

        list.printToConsole();
        list.removeAt(3);
        list.removeAt(2);
        list.removeAt(1);
        list.removeAt(0);
        list.insert(100);
        list.insert(200);
        list.insert(300);
        list.insert(400);
        list.removeAt(0);
        list.removeAt(2);
        list.removeAt(0);
        list.removeAt(0);
//        list.insert(200);
//        System.out.println(list.length);
        list.printToConsole();


        // Built in dynamic Array: ArrayList
        // The above Array is actually ArrayList custom implementation
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(100);
        arrayList.indexOf(100);
        System.out.println(arrayList);
//        arrayList.remove(0);
        System.out.println(arrayList.contains(100));
        System.out.println(arrayList.size());
        System.out.println(Arrays.toString(arrayList.toArray()));

    }

    public static int itemLookupByIndex(int[] array, int index) {
        return array[index];
    }


}