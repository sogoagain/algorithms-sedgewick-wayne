package chapter2.section4;

public class Heap {

    public static void sort(Comparable[] arr) {
        int N = arr.length;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
        }
        while (N > 1) {
            exchange(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    private static void sink(Comparable[] arr, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(arr, j, j + 1)) {
                j++;
            }
            if (!less(arr, k, j)) {
                break;
            }
            exchange(arr, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] arr, int i, int j) {
        return arr[i - 1].compareTo(arr[j - 1]) < 0;
    }

    private static void exchange(Comparable[] arr, int i, int j) {
        final Comparable temp = arr[i - 1];
        arr[i - 1] = arr[j - 1];
        arr[j - 1] = temp;
    }
}
