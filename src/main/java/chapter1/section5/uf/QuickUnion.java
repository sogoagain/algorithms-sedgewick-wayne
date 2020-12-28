package chapter1.section5.uf;

public class QuickUnion implements UF {

    private final int[] id;

    private int count;

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) {
            return;
        }

        id[i] = j;

        count--;
    }

    @Override
    public int count() {
        return count;
    }

    private int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
}
