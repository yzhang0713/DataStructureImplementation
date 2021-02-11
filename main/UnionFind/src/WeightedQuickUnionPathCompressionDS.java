import java.util.*;

public class WeightedQuickUnionPathCompressionDS implements DisjointSets {
    // Improve weighted quick union by introduce path compression

    public int[] parent;
    public int count;

    public WeightedQuickUnionPathCompressionDS(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        count = n;
    }

    // Root function
    public int root(int p) {
        int r = p;
        while (parent[r] > 0) {
            r = parent[r];
        }
        while (p != r) {
            int newp = parent[p];
            parent[p] = r;
            p = newp;
        }
        return r;
    }

    // Connect items p and q
    @Override
    public void connect(int p, int q) {
        p = root(p);
        q = root(q);
        if (parent[p] < parent[q]) {
            parent[p] += parent[q];
            parent[q] = p;
        } else if (parent[q] < parent[p]) {
            parent[q] += parent[p];
            parent[p] = q;
        }
        count--;
    }

    // Check if items p and q are connected
    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public int count() {
        return count;
    }
}
