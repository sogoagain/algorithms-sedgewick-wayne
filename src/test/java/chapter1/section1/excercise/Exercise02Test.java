package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise02Test {

    @Test
    void datatype() {
        assertThat((1 + 2.236) / 2).isInstanceOf(Double.class);
        assertThat(1 + 2 + 3 + 4.0).isInstanceOf(Double.class);
        assertThat(4.1 >= 4).isInstanceOf(Boolean.class);
        assertThat(1 + 2 + "3").isInstanceOf(String.class);
    }
}
