public class WeightedQuickUnionDS implements DisjointSets {
    // Improve on the implementation of quick union

    public int[] parent;
    public int count;

    public WeightedQuickUnionDS(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        count = n;
    }

    // Root method
    public int root(int p) {
        while (parent[p] > 0) {
            p = parent[p];
        }
        return p;
    }

    // Connect items p and q
    @Override
    public void connect(int p, int q) {
        p = root(p);
        q = root(q);
        if (parent[p] < parent[q]) {
            parent[p] = parent[p] + parent[q];
            parent[q] = p;
        } else if (parent[p] > parent[q]) {
            parent[q] = parent[p] + parent[q];
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
