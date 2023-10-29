import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Basics {
    public Basics(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
//        linkedList.remove(0);
//        linkedList.contains(1);
        System.out.println(linkedList.size());
        Object[] array = linkedList.toArray();
        System.out.println(linkedList);
        System.out.println(Arrays.toString(array));
    }
}
