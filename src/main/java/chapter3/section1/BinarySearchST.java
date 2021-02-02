package chapter3.section1;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Key[] keys;

    private Value[] vals;

    private int N;

    public BinarySearchST() {
        keys = (Key[]) new Comparable[1];
        vals = (Value[]) new Object[1];
        N = 0;
    }

    @Override
    public void put(Key key, Value val) {
        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (N == keys.length) resize(2 * keys.length);

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }

        int i = rank(key);
        if (i == N || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < N - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        N--;
        keys[N] = null;
        vals[N] = null;

        if (N > 0 && N == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        final Queue<Key> queue = new LinkedList<>();
        for (int i = 0; i < size(); i++) {
            queue.offer(keys[i]);
        }
        return queue;
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private void resize(int capacity) {
        final Key[] tempKeys = (Key[]) new Comparable[capacity];
        final Value[] tempVals = (Value[]) new Object[capacity];

        for (int i = 0; i < N; i++) {
            tempKeys[i] = keys[i];
            tempVals[i] = vals[i];
        }
        keys = tempKeys;
        vals = tempVals;
    }
}
