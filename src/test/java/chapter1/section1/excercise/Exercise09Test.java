package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise09Test {

    @Test
    void toBinaryString() {
        assertThat(Exercise09.toBinaryString(10)).isEqualTo("1010");
        assertThat(Exercise09.toBinaryString(123)).isEqualTo("1111011");
    }
}
