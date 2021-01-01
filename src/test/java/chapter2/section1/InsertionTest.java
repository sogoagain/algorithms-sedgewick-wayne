package chapter2.section1;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InsertionTest {

    @Test
    void sort() {
        final Double[] arr = new Double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform();
        }

        Insertion.sort(arr);

        assertThat(Insertion.isSorted(arr)).isTrue();
    }
}
