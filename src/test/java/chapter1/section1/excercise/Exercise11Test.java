package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise11Test {

    @Test
    void print2D() {
        final boolean[][] arr = {{true, false}, {true, true}, {false, false}};

        final String result = Exercise11.print2D(arr);

        assertThat(result).isEqualTo("[0,0]* [0,1]  \n[1,0]* [1,1]* \n[2,0]  [2,1]  \n");
    }
}
