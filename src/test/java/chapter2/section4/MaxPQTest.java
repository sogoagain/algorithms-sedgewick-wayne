package chapter2.section4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxPQTest {

    @Test
    void maxPq() {
        final String[] inputs = new String[]{"A", "B", "C", "F", "G", "I", "I", "Z"};
        final MaxPQ<String> pq = new MaxPQ<>();

        assertThat(pq.isEmpty()).isTrue();

        for (String input : inputs) {
            pq.insert(input);
        }

        assertThat(pq.isEmpty()).isFalse();
        assertThat(pq.delMax()).isEqualTo("Z");
        assertThat(pq.delMax()).isEqualTo("I");
        assertThat(pq.delMax()).isEqualTo("I");
        assertThat(pq.delMax()).isEqualTo("G");
        assertThat(pq.delMax()).isEqualTo("F");
        assertThat(pq.delMax()).isEqualTo("C");
        assertThat(pq.delMax()).isEqualTo("B");
        assertThat(pq.delMax()).isEqualTo("A");
        assertThat(pq.isEmpty()).isTrue();
    }
}
