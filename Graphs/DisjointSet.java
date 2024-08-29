package Graphs;

import java.util.*;

public class DisjointSet {
    public int[] parent;
    public int[] rank;

    public DisjointSet(int size) {
        this.parent = new int[size + 1];
        this.rank = new int[size + 1];
        for (var i = 0; i <= size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int n) {
        var p = parent[n];
        if (n == parent[n]) {
            return n;
        }
        return parent[p] = find(p);
    }

    public int union(int a, int b) {
        var parentA = find(a);
        var parentB = find(b);

        var rankA = rank[a];
        var rankB = rank[b];

        if (rankA >= rankB) {
            parent[parentB] = parentA;
            if (rankA == rankB) {
                rank[parentA]++;
            }
            return parentA;
        }
        parent[parentA] = parentB;
        return parentB;
    }
}