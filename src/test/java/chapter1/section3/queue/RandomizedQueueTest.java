package chapter1.section3.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomizedQueueTest {

    private RandomizedQueue<Integer> randomizedQueue;

    @BeforeEach
    void setUp() {
        randomizedQueue = new RandomizedQueue<>();
    }

    @Test
    void randomizedQueue() {
        assertThat(randomizedQueue.isEmpty()).isTrue();
        assertThat(randomizedQueue.size()).isEqualTo(0);

        randomizedQueue.enqueue(10);
        randomizedQueue.enqueue(20);
        assertThat(randomizedQueue.isEmpty()).isFalse();
        assertThat(randomizedQueue.size()).isEqualTo(2);

        final Set<Integer> numberSet1 = new HashSet<>();
        numberSet1.add(randomizedQueue.dequeue());
        numberSet1.add(randomizedQueue.dequeue());
        assertThat(randomizedQueue.isEmpty()).isTrue();
        assertThat(randomizedQueue.size()).isEqualTo(0);

        assertThat(numberSet1).contains(10, 20);

        randomizedQueue.enqueue(30);
        assertThat(randomizedQueue.sample()).isEqualTo(30);

        randomizedQueue.enqueue(50);
        randomizedQueue.enqueue(60);
        randomizedQueue.enqueue(70);
        randomizedQueue.enqueue(80);
        randomizedQueue.enqueue(90);
        randomizedQueue.enqueue(100);

        final Set<Integer> numberSet2 = new HashSet<>();
        for (int number : randomizedQueue) {
            numberSet2.add(number);
        }
        assertThat(numberSet2).contains(50, 60, 70, 80, 90, 100);
    }

    @Test
    void enqueueWithNull() {
        assertThatThrownBy(() -> randomizedQueue.enqueue(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sampleWhenEmpty() {
        assertThatThrownBy(() -> randomizedQueue.sample())
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    void dequeueWhenEmpty() {
        assertThatThrownBy(() -> randomizedQueue.dequeue())
                .isExactlyInstanceOf(NoSuchElementException.class);
    }

    @Test
    void nextWhenNoMoreItems() {
        final Iterator<Integer> iterator = randomizedQueue.iterator();
        assertThatThrownBy(iterator::next)
                .isExactlyInstanceOf(NoSuchElementException.class);
    }
}
