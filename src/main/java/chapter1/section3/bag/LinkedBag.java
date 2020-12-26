package chapter1.section3.bag;

import java.util.Iterator;

public class LinkedBag<T> implements Bag<T> {

    private Node first;

    private int N;

    @Override
    public void add(T item) {
        final Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
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
