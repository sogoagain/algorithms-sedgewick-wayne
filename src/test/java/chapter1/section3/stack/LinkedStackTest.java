package chapter1.section3.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedStackTest {

    final Stack<String> stack = new LinkedStack<>();

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

        int i = values.length;
        for (String item : stack) {
            assertThat(item).isEqualTo(values[--i]);
        }
    }
}
