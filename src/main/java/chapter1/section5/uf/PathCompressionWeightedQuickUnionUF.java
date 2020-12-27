package chapter1.section5.uf;

public class PathCompressionWeightedQuickUnionUF extends WeightedQuickUnionUF {

    public PathCompressionWeightedQuickUnionUF(int N) {
        super(N);
    }

    @Override
    protected int root(int i) {
        int root = i;
        while (id[root] != root) {
            id[root] = id[id[root]];
            root = id[root];
        }
        return root;
    }
}
