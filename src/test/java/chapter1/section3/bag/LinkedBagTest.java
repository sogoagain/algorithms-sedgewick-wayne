package chapter1.section3.bag;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedBagTest {

    private Bag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new LinkedBag<>();
    }

    @Test
    void addAndSize() {
        bag.add("hello");
        bag.add("world");

        assertThat(bag.size()).isEqualTo(2);
    }

    @Test
    void isEmpty() {
        assertThat(bag.isEmpty()).isTrue();
        bag.add("Hello World!");
        assertThat(bag.isEmpty()).isFalse();
    }

    @Test
    void iterator() {
        final String[] values = {"abc", "def", "ghi"};

        for (String value : values) {
            bag.add(value);
        }

        final String[] result = new String[values.length];
        int i = 0;
        for (String item : bag) {
            result[i] = item;
            i++;
        }

        assertThat(result).containsExactlyInAnyOrder(values);
    }
}
