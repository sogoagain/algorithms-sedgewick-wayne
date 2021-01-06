package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DoublingTestTest {

    @Test
    @Disabled
    void doublingTest() {
        for (int N = 250; true; N += N) {
            double time = DoublingTest.timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }

    @Test
    @Disabled
    void doublingRatio() {
        double prev = DoublingTest.timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = DoublingTest.timeTrial(N);
            StdOut.printf("%6d %7.1f ", N, time);
            StdOut.printf("%5.1f\n", time / prev);
            prev = time;
        }
    }
}
