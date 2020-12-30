package chapter1.section3.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] arr;

    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[1];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = item;
    }


    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        final int randomIndex = StdRandom.uniform(size);
        final Item item = arr[randomIndex];

        arr[randomIndex] = arr[size - 1];
        arr[size - 1] = null;
        size--;

        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }

        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        final int index = StdRandom.uniform(size);
        return arr[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

    private void resize(int size) {
        final Item[] temp = (Item[]) new Object[size];
        for (int i = 0; i < this.size; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    private class RandomIterator implements Iterator<Item> {

        private final Item[] items;

        private int current;

        public RandomIterator() {
            items = (Item[]) new Object[size];
            for (int i = 0; i < items.length; i++) {
                items[i] = arr[i];
            }
            StdRandom.shuffle(items);
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return current < items.length;
        }

        @Override
        public Item next() {
            if (current == items.length) {
                throw new NoSuchElementException();
            }
            return items[current++];
        }
    }
}
