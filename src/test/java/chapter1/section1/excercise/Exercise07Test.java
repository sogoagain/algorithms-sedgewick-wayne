package chapter1.section1.excercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise07Test {

    @Test
    void a() {
        assertThat(Exercise07.a()).isEqualTo("3.00009");
    }

    @Test
    void b() {
        assertThat(Exercise07.b()).isEqualTo("499500");
    }

    @Test
    void c() {
        assertThat(Exercise07.c()).isEqualTo("10000");
    }
}
