package chapter2.section4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinPQTest {

    @Test
    void minPq() {
        final String[] inputs = new String[]{"Z", "I", "I", "G", "F", "C", "B", "A"};
        final MinPQ<String> pq = new MinPQ<>();

        assertThat(pq.isEmpty()).isTrue();

        for (String input : inputs) {
            pq.insert(input);
        }

        assertThat(pq.isEmpty()).isFalse();
        assertThat(pq.delMin()).isEqualTo("A");
        assertThat(pq.delMin()).isEqualTo("B");
        assertThat(pq.delMin()).isEqualTo("C");
        assertThat(pq.delMin()).isEqualTo("F");
        assertThat(pq.delMin()).isEqualTo("G");
        assertThat(pq.delMin()).isEqualTo("I");
        assertThat(pq.delMin()).isEqualTo("I");
        assertThat(pq.delMin()).isEqualTo("Z");
        assertThat(pq.isEmpty()).isTrue();
    }
}
