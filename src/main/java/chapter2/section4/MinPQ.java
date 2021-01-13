package chapter2.section4;

public class MinPQ<Key extends Comparable<Key>> {

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

    public Key delMin() {
        final Key min = pq[1];
        exchange(1, N--);
        pq[N + 1] = null;
        sink(1);
        if ((N > 0) && (N == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        return min;
    }

    private void resize(int size) {
        final Key[] temp = (Key[]) new Comparable[size];
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
        while (k > 1 && less(k, k / 2)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j + 1, j)) {
                j++;
            }
            if (!less(j, k)) {
                break;
            }
            exchange(j, k);
            k = j;
        }
    }
}
