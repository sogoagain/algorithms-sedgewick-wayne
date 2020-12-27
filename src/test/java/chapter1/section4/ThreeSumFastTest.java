package chapter1.section4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSumFastTest {

    @Test
    void count() {
        assertThat(ThreeSumFast.count(new int[]{1, 2, 3, -1, -2, -3})).isEqualTo(2);
        assertThat(ThreeSumFast.count(new int[]{30, -40, -20, 10, 40, 5})).isEqualTo(1);
    }
}
