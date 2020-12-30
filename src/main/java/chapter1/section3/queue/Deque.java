package chapter1.section3.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first;

    private Node last;

    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        final Node node = new Node();
        node.item = item;
        node.right = first;

        if (first != null) {
            first.left = node;
        } else {
            last = node;
        }
        first = node;

        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        final Node node = new Node();
        node.item = item;
        node.left = last;

        if (last != null) {
            last.right = node;
        } else {
            first = node;
        }
        last = node;

        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        final Item item = first.item;

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.right;
            first.left = null;
        }

        size--;

        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }

        final Item item = last.item;

        if (first == last) {
            first = null;
            last = null;
        } else {
            last = last.left;
            last.right = null;
        }

        size--;

        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

    private class Node {

        Item item;

        Node left;

        Node right;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            final Item item = current.item;
            current = current.right;

            return item;
        }
    }
}
