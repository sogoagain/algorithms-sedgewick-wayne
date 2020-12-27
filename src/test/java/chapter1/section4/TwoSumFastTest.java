package chapter1.section4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumFastTest {

    @Test
    void count() {
        assertThat(TwoSumFast.count(new int[]{1, 2, 3, -1, -2, -3})).isEqualTo(3);
        assertThat(TwoSumFast.count(new int[]{30, -40, -20, 10, 40, 5})).isEqualTo(1);
    }
}
