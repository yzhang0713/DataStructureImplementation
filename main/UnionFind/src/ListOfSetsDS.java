import java.util.*;

public class ListOfSetsDS implements DisjointSets {
    // Use list of sets to implement the functionality of disjoint sets

    public List<Set<Integer>> setList;
    public int count;

    public ListOfSetsDS(int n) {
        for (int i = 0; i < n; i++) {
            Set<Integer> curSet = new HashSet<>();
            curSet.add(i);
            setList.add(curSet);
        }
        count = n;
    }

    // Connect items P and Q
    @Override
    public void connect(int p, int q) {
        Set<Integer> mergedSet = new HashSet<>();
        for (Set<Integer> curSet : setList) {
            if (curSet.contains(p)) {
                if (curSet.contains(q)) {
                    return;
                } else {
                    mergedSet.addAll(curSet);
                    setList.remove(curSet);
                }
            } else {
                if (curSet.contains(q)) {
                    mergedSet.addAll(curSet);
                    setList.remove(curSet);
                }
            }
        }
        setList.add(mergedSet);
        count--;
    }

    // Check if two items p and q are connected
    @Override
    public boolean isConnected(int p, int q) {
        for (Set<Integer> curSet : setList) {
            if (curSet.contains(p) && curSet.contains(q)) {
                return true;
            }
        }
        return false;
    }

    public int count() {
        return count;
    }
}
