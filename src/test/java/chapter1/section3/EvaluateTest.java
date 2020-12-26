package chapter1.section3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EvaluateTest {

    @Test
    void calculateWithOnlyNumber() {
        assertThat(Evaluate.calculate("1")).isEqualTo(1.0);
    }

    @Test
    void calculateWithSqrt() {
        assertThat(Evaluate.calculate("( ( 1 + sqrt ( 5.0 ) ) / 2.0 )")).isEqualTo(1.618033988749895);
    }

    @Test
    void calculate() {
        assertThat(Evaluate.calculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")).isEqualTo(101.0);
    }
}
