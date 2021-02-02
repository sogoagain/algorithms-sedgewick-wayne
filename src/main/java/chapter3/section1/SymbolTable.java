package chapter3.section1;

public interface SymbolTable<Key, Value> {

    void put(Key key, Value val);

    Value get(Key key);

    Key[] keys();

    boolean contains(Key key);
}
