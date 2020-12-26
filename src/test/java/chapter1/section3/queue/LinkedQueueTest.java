package chapter1.section3.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedQueueTest {

    final Queue<String> queue = new LinkedQueue<>();

    @Test
    void enqueueAndDequeue() {
        queue.enqueue("hello");
        queue.enqueue("world");

        assertThat(queue.dequeue()).isEqualTo("hello");
    }

    @Test
    void isEmpty() {
        assertThat(queue.isEmpty()).isTrue();
        queue.enqueue("Hello World!");
        assertThat(queue.isEmpty()).isFalse();
        queue.dequeue();
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void size() {
        queue.enqueue("hello");
        queue.enqueue("world");

        assertThat(queue.size()).isEqualTo(2);
    }

    @Test
    void iterator() {
        final String[] values = {"abc", "def", "ghi"};

        for (String value : values) {
            queue.enqueue(value);
        }

        int i = 0;
        for (String item : queue) {
            assertThat(item).isEqualTo(values[i++]);
        }
    }
}
