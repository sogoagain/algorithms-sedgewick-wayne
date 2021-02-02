package chapter3.section1;

public class SymbolTableTestClient {

    private final SymbolTable<String, Integer> symbolTable;

    public SymbolTableTestClient(SymbolTable<String, Integer> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public String indexing(String input) {
        final String[] keys = input.split(" ");

        for (int i = 0; i < keys.length; i++) {
            final String key = keys[i];
            symbolTable.put(key, i);
        }

        final StringBuilder stringBuilder = new StringBuilder();
        for (String key : symbolTable.keys()) {
            stringBuilder.append(key);
            stringBuilder.append(" ");
            stringBuilder.append(symbolTable.get(key));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
