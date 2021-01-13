package chapter2.section4;

public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq = (Key[]) new Comparable[1];

    private int N = 0;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        if (N == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        final Key max = pq[1];
        exchange(1, N--);
        pq[N + 1] = null;
        sink(1);
        if ((N > 0) && (N == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return max;
    }

    private void resize(int max) {
        Key[] temp = (Key[]) new Comparable[max];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        final Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(k, j);
            k = j;
        }
    }
}
