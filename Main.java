import java.util.*;

import Graphs.DisjointSet;

class Main {

    public static void main(String[] args) {
        var ds = new DisjointSet(4);
        System.out.println(ds.find(1));
        ds.union(1, 2);
        System.out.println(ds.find(2));
        ds.union(3, 4);
        System.out.println(ds.find(3));

        System.out.println(ds.parent);
        System.out.println(ds.rank);
        System.out.println(ds.numberOfDisjointSets());
    }

}
