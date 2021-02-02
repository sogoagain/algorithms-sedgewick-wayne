package chapter3.section1;

import java.util.LinkedList;
import java.util.Queue;

public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

    private Node first;

    private int N = 0;

    @Override
    public void put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        N++;
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        put(key, null);
        N--;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() != 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterable<Key> keys() {
        final Queue<Key> queue = new LinkedList<>();

        for (Node x = first; x != null; x = x.next) {
            queue.offer(x.key);
        }

        return queue;
    }

    private class Node {

        Key key;

        Value val;

        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
}
