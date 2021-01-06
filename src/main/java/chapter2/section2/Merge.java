package chapter2.section2;

public class Merge {

    private static Comparable[] temp;

    public static void sort(Comparable[] arr) {
        temp = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        final int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > hi) {
                arr[k] = temp[i++];
            } else if (less(temp[j], temp[i])) {
                arr[k] = temp[j++];
            } else {
                arr[k] = temp[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
