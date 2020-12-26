package chapter1.section3.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedStackTest {

    private Stack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void pushAndPop() {
        stack.push("hello");
        stack.push("world");

        assertThat(stack.pop()).isEqualTo("world");
    }

    @Test
    void isEmpty() {
        assertThat(stack.isEmpty()).isTrue();
        stack.push("Hello World!");
        assertThat(stack.isEmpty()).isFalse();
        stack.pop();
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void size() {
        stack.push("hello");
        stack.push("world");

        assertThat(stack.size()).isEqualTo(2);
    }

    @Test
    void iterator() {
        final String[] values = {"abc", "def", "ghi"};

        for (String value : values) {
            stack.push(value);
        }

        final String[] result = new String[values.length];
        int i = 0;
        for (String item : stack) {
            result[i] = item;
            i++;
        }

        assertThat(result).containsExactlyInAnyOrder(values);
    }
}
