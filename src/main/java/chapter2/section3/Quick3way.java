package chapter2.section3;

import edu.princeton.cs.algs4.StdRandom;

public class Quick3way {

    public static void sort(Comparable[] arr) {
        StdRandom.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        final Comparable v = arr[lo];

        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                exchange(arr, lt++, i++);
            } else if (cmp > 0) {
                exchange(arr, i, gt--);
            } else {
                i++;
            }
        }

        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }

    private static void exchange(Comparable[] arr, int i, int j) {
        final Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
