public class QuickFindDS implements DisjointSets {
    // Use array to implement the disjoint sets
    // Naive array setup, change id value to same number to connect

    public int[] id;
    public int count;

    public QuickFindDS(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    // Connect items p and q
    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        if (pid == qid) {
            return;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == qid) {
                    id[i] = pid;
                }
            }
        }
        count--;
    }

    // Check if items p and q are connected
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public int count() {
        return count;
    }

}
