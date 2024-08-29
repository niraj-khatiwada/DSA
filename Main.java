import java.util.*;

import Graphs.DisjointSet;

class Main {

    public static void main(String[] args) {
        var ds = new DisjointSet(7);
        System.out.println(ds.find(1));
        ds.union(1, 2);
        System.out.println(ds.find(2));
        ds.union(2, 3);
        System.out.println(ds.find(3));

        System.out.println(ds.parent);
        System.out.println(ds.rank);
    }

}
