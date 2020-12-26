package chapter1.section3.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] arr = (T[]) new Object[1];

    private int N = 0;

    @Override
    public void push(T item) {
        if (N == arr.length) {
            resize(2 * arr.length);
        }
        arr[N++] = item;
    }

    @Override
    public T pop() {
        final T item = arr[--N];
        arr[N] = null; // 로이터링(loitering) 방지
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    private void resize(int max) {
        final T[] temp = (T[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            if (i == 0) {
                throw new NoSuchElementException();
            }
            return arr[--i];
        }
    }
}
