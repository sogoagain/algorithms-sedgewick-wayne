package chapter2.section1;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {

    public static void shuffle(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int r = StdRandom.uniform(i + 1);
            exchange(arr, r, i);
        }
    }

    private static void exchange(Object[] arr, int r, int i) {
        final Object temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
    }
}
