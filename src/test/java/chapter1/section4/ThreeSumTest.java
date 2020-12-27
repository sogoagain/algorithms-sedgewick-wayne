package chapter1.section4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSumTest {

    @Test
    void count() {
        final int[] arr = {1, 2, 3, -1, -2, -3};

        assertThat(ThreeSum.count(arr)).isEqualTo(2);
    }
}
