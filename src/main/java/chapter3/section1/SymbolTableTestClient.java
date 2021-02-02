package chapter3.section1;

public class SymbolTableTestClient {

    private final ST<String, Integer> st;

    public SymbolTableTestClient(ST<String, Integer> st) {
        this.st = st;
    }

    public String indexing(String input) {
        final String[] keys = input.split(" ");

        for (int i = 0; i < keys.length; i++) {
            final String key = keys[i];
            st.put(key, i);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (String key : st.keys()) {
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append(st.get(key));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
