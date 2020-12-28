package chapter1.section5.uf;

public interface UF {

    boolean connected(int p, int q);

    void union(int p, int q);

    int count();
}
