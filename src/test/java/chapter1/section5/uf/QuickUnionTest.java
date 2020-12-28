package chapter1.section5.uf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickUnionTest {

    private UF uf;

    @BeforeEach
    void setUp() {
        uf = new QuickUnion(10);
    }

    @Test
    void UnionAndConnectedAndCount() {
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(8, 9);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);
        uf.union(6, 7);

        assertThat(uf.connected(1, 0)).isTrue();
        assertThat(uf.connected(1, 2)).isTrue();
        assertThat(uf.connected(1, 7)).isTrue();
        assertThat(uf.connected(0, 5)).isTrue();
        assertThat(uf.connected(0, 6)).isTrue();

        assertThat(uf.connected(8, 3)).isTrue();
        assertThat(uf.connected(8, 9)).isTrue();
        assertThat(uf.connected(3, 4)).isTrue();

        assertThat(uf.connected(1, 8)).isFalse();
        assertThat(uf.connected(2, 3)).isFalse();
        assertThat(uf.connected(5, 9)).isFalse();
        assertThat(uf.connected(6, 4)).isFalse();

        assertThat(uf.count()).isEqualTo(2);
    }
}
