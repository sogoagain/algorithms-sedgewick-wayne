package chapter1.section5.percolation;

import chapter1.section5.percolation.Percolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PercolationTest {

    private final static int N = 5;

    private Percolation percolation;

    @BeforeEach
    void setUp() {
        percolation = new Percolation(N);

        percolation.open(1, 1);
        percolation.open(1, 2);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(3, 2);
        percolation.open(3, 4);
        percolation.open(3, 5);
        percolation.open(4, 1);
        percolation.open(4, 3);
        percolation.open(5, 1);
        percolation.open(5, 2);
        percolation.open(5, 4);
        percolation.open(5, 5);
    }

    @Test
    void creationWithIllegalRange() {
        assertThatThrownBy(() -> new Percolation(0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void openWithIllegalRange() {
        assertThatThrownBy(() -> percolation.open(0, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.open(0, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.open(N + 1, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.open(N + 1, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isOpen() {
        assertThat(percolation.isOpen(2, 4)).isTrue();
        assertThat(percolation.isOpen(3, 5)).isTrue();
        assertThat(percolation.isOpen(5, 2)).isTrue();

        assertThat(percolation.isOpen(2, 1)).isFalse();
        assertThat(percolation.isOpen(2, 2)).isFalse();
        assertThat(percolation.isOpen(4, 5)).isFalse();
    }

    @Test
    void isOpenWithIllegalRange() {
        assertThatThrownBy(() -> percolation.isOpen(0, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isOpen(0, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isOpen(N + 1, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isOpen(N + 1, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isFull() {
        assertThat(percolation.isFull(1, 4)).isTrue();
        assertThat(percolation.isFull(2, 4)).isTrue();
        assertThat(percolation.isFull(3, 4)).isTrue();
        assertThat(percolation.isFull(3, 5)).isTrue();

        assertThat(percolation.isFull(3, 2)).isFalse();
        assertThat(percolation.isFull(4, 3)).isFalse();
        assertThat(percolation.isFull(4, 4)).isFalse();
        assertThat(percolation.isFull(4, 5)).isFalse();
        assertThat(percolation.isFull(5, 1)).isFalse();
    }

    @Test
    void isFullWithIllegalRange() {
        assertThatThrownBy(() -> percolation.isFull(0, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isFull(0, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isFull(N + 1, 0))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> percolation.isFull(N + 1, N + 1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numberOfOpenSites() {
        assertThat(percolation.numberOfOpenSites()).isEqualTo(13);
    }

    @Test
    void percolates() {
        assertThat(percolation.percolates()).isFalse();

        percolation.open(4, 4);

        assertThat(percolation.percolates()).isTrue();
    }
}
