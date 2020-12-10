package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise14Test {

    @Test
    void lg() {
        assertThat(Exercise14.lg(8)).isEqualTo(3);
        assertThat(Exercise14.lg(9)).isEqualTo(3);
        assertThat(Exercise14.lg(282)).isEqualTo(8);
    }
}
