import java.util.*;

import DisjointSet.DisjointSetByRank;
import DisjointSet.DisjointSet;

class Main {

    public static void main(String[] args) {
        var dsByRank = new DisjointSetByRank(5);
        dsByRank.union(0, 3);
        dsByRank.union(0, 5);
        dsByRank.union(2, 3);
        dsByRank.union(2, 5);
        dsByRank.union(1, 4);
        System.out.println(dsByRank.size(0));
        System.out.println(Arrays.toString(dsByRank.parent));

        var ds = new DisjointSet(5);
        ds.union(0, 3);
        ds.union(0, 5);
        ds.union(2, 3);
        ds.union(2, 5);
        ds.union(1, 4);

        System.out.println(ds.size(0));
        System.out.println(Arrays.toString(ds.parent));

    }

}
