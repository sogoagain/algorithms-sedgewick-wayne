package chapter1.section3.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);

        final RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < count; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
