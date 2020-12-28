package chapter1.section5.uf;

public class QuickFind implements UF {

    private final int[] id;

    private int count;

    public QuickFind(int N) {
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
        final int pId = find(p);
        final int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        count--;
    }

    @Override
    public int count() {
        return count;
    }

    private int find(int p) {
        return id[p];
    }
}
