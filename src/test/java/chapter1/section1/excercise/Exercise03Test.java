package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise03Test {

    @Test
    void equal() {
        assertThat(Exercise03.equal(1, 1, 1)).isEqualTo("equal");
        assertThat(Exercise03.equal(1, 2, 1)).isEqualTo("not equal");
        assertThat(Exercise03.equal(1, 2, 2)).isEqualTo("not equal");
        assertThat(Exercise03.equal(1, 2, 3)).isEqualTo("not equal");
    }
}
