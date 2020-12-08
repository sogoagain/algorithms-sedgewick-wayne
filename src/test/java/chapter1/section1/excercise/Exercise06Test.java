package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise06Test {

    @Test
    void fibonacci() {
        final int[] result = Exercise06.fibonacci();

        assertThat(result).containsExactly(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610);
    }
}
