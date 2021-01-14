package chapter2.section4;

import chapter2.section1.Selection;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeapTest {

    @Test
    void sort() {
        final Double[] arr = new Double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform();
        }

        Heap.sort(arr);

        assertThat(Selection.isSorted(arr)).isTrue();
    }
}
