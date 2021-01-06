package chapter2.section2;

public class MergeBU {

    private static Comparable[] temp;

    public static void sort(Comparable[] arr) {
        temp = new Comparable[arr.length];

        for (int size = 1; size < arr.length; size += size) {
            for (int lo = 0; lo < arr.length - size; lo += size + size) {
                merge(arr, lo, lo + size - 1, Math.min(lo + size + size - 1, arr.length - 1));
            }
        }
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

    private static boolean less(Comparable u, Comparable w) {
        return u.compareTo(w) < 0;
    }
}
