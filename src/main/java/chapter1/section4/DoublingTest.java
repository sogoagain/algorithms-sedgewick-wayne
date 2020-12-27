package chapter1.section4;

import edu.princeton.cs.algs4.StdRandom;

public class DoublingTest {

    public static double timeTrial(int N) {
        final int MAX = 1_000_000;
        final int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform(-MAX, MAX);
        }

        final Stopwatch timer = new Stopwatch();
        ThreeSum.count(arr);
        return timer.elapsedTime();
    }
}
