package chapter1.section3.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FixedCapacityStackOfStrings implements Stack<String> {

    private final String[] arr;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        arr = new String[cap];
        N = 0;
    }

    @Override
    public void push(String item) {
        arr[N++] = item;
    }

    @Override
    public String pop() {
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
    public Iterator<String> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<String> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public String next() {
            if (i == 0) {
                throw new NoSuchElementException();
            }
            return arr[--i];
        }
    }
}
