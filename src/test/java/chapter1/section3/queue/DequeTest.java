package chapter1.section3.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DequeTest {

    private Deque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new Deque<>();
    }

    @Test
    void deque() {
        assertThat(deque.isEmpty()).isTrue();
        assertThat(deque.size()).isEqualTo(0);

        deque.addFirst(10);
        deque.addFirst(20);
        assertThat(deque.isEmpty()).isFalse();
        assertThat(deque.size()).isEqualTo(2);

        assertThat(deque.removeFirst()).isEqualTo(20);
        assertThat(deque.removeFirst()).isEqualTo(10);
        assertThat(deque.isEmpty()).isTrue();
        assertThat(deque.size()).isEqualTo(0);

        deque.addLast(30);
        deque.addLast(40);
        assertThat(deque.isEmpty()).isFalse();
        assertThat(deque.size()).isEqualTo(2);

        assertThat(deque.removeLast()).isEqualTo(40);
        assertThat(deque.removeLast()).isEqualTo(30);
        assertThat(deque.isEmpty()).isTrue();
        assertThat(deque.size()).isEqualTo(0);

        deque.addFirst(50);
        deque.addFirst(60);
        deque.addLast(70);
        deque.addLast(80);
        deque.addFirst(90);
        deque.addLast(100);

        final int[] numbers = new int[]{90, 60, 50, 70, 80, 100};
        int i = 0;
        for (int number : deque) {
            assertThat(number).isEqualTo(numbers[i++]);
        }
    }

    @Test
    void addFirstWithNull() {
        assertThatThrownBy(() -> deque.addFirst(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addLastWithNull() {
        assertThatThrownBy(() -> deque.addLast(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void removeFirstWhenEmpty() {
        assertThatThrownBy(() -> deque.removeFirst())
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    void removeLastWhenEmpty() {
        assertThatThrownBy(() -> deque.removeLast())
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    void nextWhenNoMoreItems() {
        final Iterator<Integer> iterator = deque.iterator();
        assertThatThrownBy(iterator::next)
                .isExactlyInstanceOf(NoSuchElementException.class);
    }
}
