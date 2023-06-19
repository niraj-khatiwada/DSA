package LinkedListDSA;

import java.util.Arrays;

public class Main {
    public static void main(String[] __) {
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        System.out.println(list.hasLoop());
    }
}
