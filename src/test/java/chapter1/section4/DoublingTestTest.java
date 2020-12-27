package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DoublingTestTest {

    @Test
    @Disabled
    void timeTrial() {
        for (int N = 250; true; N += N) {
            double time = DoublingTest.timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
