package DisjointSet;

import java.util.*;

public class DisjointSet {
    public int[] parent;

    public DisjointSet(int size) {
        this.parent = new int[size + 1];
        Arrays.fill(this.parent, -1);

    }

    // O(1)
    public int find(int n) {
        var p = parent[n];

        if (p < 0) {
            return n;
        }

        return parent[n] = find(p); // path compression
    }

    // O(1)
    public int union(int a, int b) {
        var parentA = find(a);
        var parentB = find(b);

        if (parentA == parentB) {
            return parentA;
        }

        var sizeA = -1 * parent[parentA];
        var sizeB = -1 * parent[parentB];

        if (sizeA >= sizeB) {
            parent[b] = parentA;
            parent[parentA]--;
            return parentA;
        }
        parent[a] = parentB;
        parent[parentB]--;
        return parentB;
    }

    // O(1)
    public int size(int a) {
        return parent[find(a)] * -1;
    }

}
