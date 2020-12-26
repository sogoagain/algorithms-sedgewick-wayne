package chapter1.section3.queue;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {

    private Node first;

    private Node last;

    private int N;

    @Override
    public void enqueue(T item) {
        final Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public T dequeue() {
        final T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class Node {

        T item;

        Node next;
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            final T item = current.item;
            current = current.next;
            return item;
        }
    }
}
