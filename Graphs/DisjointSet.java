package Graphs;

import java.util.*;

public class DisjointSet {
    public List<Integer> parent;
    public List<Integer> rank;

    public DisjointSet(int size) {
        // If size is 7, you can only pass values between 1 & 7.
        this.parent = new ArrayList<Integer>();
        this.rank = new ArrayList<Integer>();
        for (var i = 0; i <= size; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int find(int n) {
        var p = parent.get(n);
        if (p == n) {
            return n;
        }
        return find(p);
    }

    public int union(int a, int b) {
        var rankA = rank.get(a);
        var rankB = rank.get(b);

        var parentA = find(a);
        var parentB = find(b);

        if (rankA >= rankB) {
            parent.set(parentB, parentA);
            if (rankA == rankB) {
                rank.set(parentA, rankB + rankA + 1);
            }
            return parentA;
        }
        parent.set(parentA, parentB);
        return parentB;
    }

    public int numberOfDisjointSets() {
        var c = 0;
        for (var i = 0; i < parent.size(); i++) {
            if (parent.get(i) == i) {
                c++;
            }
        }
        return c - 1; // -1 for 0
    }
}