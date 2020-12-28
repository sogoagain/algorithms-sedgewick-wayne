package chapter1.section5.uf;

public class WeightedQuickUnion implements UF {

    protected final int[] id;

    private final int[] sz;

    private int count;

    public WeightedQuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }

        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    @Override
    public int count() {
        return count;
    }

    protected int root(int i) {
        int root = i;
        while (id[root] != root) {
            root = id[root];
        }
        return root;
    }
}
