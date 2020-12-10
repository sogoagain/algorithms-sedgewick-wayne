package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise13Test {

    @Test
    void rotate() {
        final int[][] matrix = {{3, 2}, {1, 3}, {4, 3}};

        final int[][] result = Exercise13.rotate(matrix);

        assertThat(result).isDeepEqualTo(new int[][]{{3, 1, 4}, {2, 3, 3}});
    }
}
