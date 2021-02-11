public class QuickUnionDS implements DisjointSets {
    // Use array to implement disjoint sets
    // Quick union method
    public int[] parent;
    public int count;

    public QuickUnionDS(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        count = n;
    }

    // Connect items p and q
    @Override
    public void connect(int p, int q) {
        p = root(p);
        q = root(q);
        if (p != q) {
            parent[q] = p;
        }
        count--;
    }

    // Check if items p and q are connected
    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    // Find root of a value p
    public int root(int p) {
        while (parent[p] != -1) {
            p = parent[p];
        }
        return p;
    }

}
