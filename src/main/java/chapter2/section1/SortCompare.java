package chapter2.section1;

import chapter1.section4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        final Double[] arr = new Double[N];

        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                arr[i] = StdRandom.uniform();
            }
            total += time(alg, arr);
        }
        return total;
    }

    private static double time(String alg, Double[] arr) {
        final Stopwatch timer = new Stopwatch();

        if (alg.equals("Insertion")) {
            Insertion.sort(arr);
        }
        if (alg.equals("Selection")) {
            Selection.sort(arr);
        }
        if (alg.equals("Shell")) {
            Shell.sort(arr);
        }

        return timer.elapsedTime();
    }
}
