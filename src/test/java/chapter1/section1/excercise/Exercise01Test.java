package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise01Test {

    @Test
    void expression() {
        assertThat((0 + 15) / 2).isEqualTo(7);
        assertThat(2.0e-6 * 100000000.1).isEqualTo(200.0000002);
        assertThat(true && false || true & true).isEqualTo(true);
    }
}
