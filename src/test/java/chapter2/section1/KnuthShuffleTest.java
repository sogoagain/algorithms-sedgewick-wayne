package chapter2.section1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KnuthShuffleTest {

    @Test
    void shuffle() {
        final Integer[] arr = new Integer[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        KnuthShuffle.shuffle(arr);
        assertThat(Insertion.isSorted(arr)).isFalse();
    }
}
