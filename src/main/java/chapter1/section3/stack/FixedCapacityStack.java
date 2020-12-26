package chapter1.section3.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStack<T> implements Stack<T> {

    private final T[] arr;

    private int N;

    public FixedCapacityStack(int cap) {
        arr = (T[]) new Object[cap];
        N = 0;
    }

    @Override
    public void push(T item) {
        arr[N++] = item;
    }

    @Override
    public T pop() {
        return arr[--N];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
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
