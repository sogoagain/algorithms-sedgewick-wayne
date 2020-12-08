package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise05Test {

    @Test
    void isBetween0and1() {
        assertThat(Exercise05.isBetween0and1(0.99, 0.99)).isTrue();
        assertThat(Exercise05.isBetween0and1(0.01, 0.01)).isTrue();
        assertThat(Exercise05.isBetween0and1(-0.01, 0.01)).isFalse();
        assertThat(Exercise05.isBetween0and1(0.01, 1.01)).isFalse();
    }
}
