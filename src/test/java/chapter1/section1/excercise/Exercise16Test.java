package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise16Test {

    @Test
    void exR1() {
        final String result = Exercise16.exR1(6);

        assertThat(result).isEqualTo("311361142246");
    }
}
