package chapter2.section3;

import chapter2.section1.Selection;
import edu.princeton.cs.algs4.StdRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Quick3wayTest {

    @Test
    void sort() {
        final Double[] arr = new Double[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = StdRandom.uniform();
        }

        Quick3way.sort(arr);

        Assertions.assertThat(Selection.isSorted(arr)).isTrue();
    }
}
