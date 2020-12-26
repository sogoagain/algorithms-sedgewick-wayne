package chapter1.section3.stack;

public interface Stack<T> extends Iterable<T> {

    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}
