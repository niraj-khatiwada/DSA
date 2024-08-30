package DisjointSet;

import java.util.*;

public class DisjointSetByRank {
    public int[] parent;
    public int[] rank;
    public int[] size; // size of each disjoint set;

    public DisjointSetByRank(int len) {
        this.parent = new int[len + 1];
        this.rank = new int[len + 1];
        this.size = new int[len + 1];
        for (var i = 0; i <= len; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int find(int n) {
        var p = parent[n];
        if (n == parent[n]) {
            return n;
        }
        return parent[p] = find(p); // Path compression or Collapsing Find
    }

    public int union(int a, int b) {
        var parentA = find(a);
        var parentB = find(b);

        var rankA = rank[parentA];
        var rankB = rank[parentB];

        if (rankA >= rankB) {
            size[parentB]--;
            parent[parentB] = parentA;
            if (rankA == rankB) {
                rank[parentA]++;
            }
            size[parentA]++;
            return parentA;
        }
        size[parentA]--;
        parent[parentA] = parentB;
        size[parentB]++;
        return parentB;
    }

    public int size(int n) {
        return size[n];
    }
}