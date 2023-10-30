package HashMaps;

import java.util.HashSet;

public class Hashset {


    public static void set(String[] args) {

        HashSet<Integer> unique = new HashSet<>();

        unique.add(1);
        unique.add(2);
        unique.add(1);
        System.out.println(unique);
        unique.clear();
        System.out.println(unique);

    }
}