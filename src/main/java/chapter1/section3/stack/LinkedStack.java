package chapter1.section3.stack;

import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

    private Node first;

    private int N;

    @Override
    public void push(T item) {
        final Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public T pop() {
        final T item = first.item;
        first = first.next;
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
            return current.next != null;
        }

        @Override
        public T next() {
            final T item = (T) current.item;
            current = current.next;
            return item;
        }
    }
}
