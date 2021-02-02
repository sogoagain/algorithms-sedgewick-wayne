package chapter3.section1;

public class FrequencyCounter {

    private final SymbolTable<String, Integer> symbolTable;

    public FrequencyCounter(SymbolTable<String, Integer> symbolTable) {
        this.symbolTable = symbolTable;
    }

    public String count(int minLength, String[] texts) {
        for (String text : texts) {
            final String[] words = text.split(" ");
            for (String word : words) {
                if (word.length() < minLength) {
                    continue;
                }
                if (!symbolTable.contains(word)) {
                    symbolTable.put(word, 1);
                } else {
                    symbolTable.put(word, symbolTable.get(word) + 1);
                }
            }
        }

        String max = "";
        symbolTable.put(max, 0);
        for (String word : symbolTable.keys()) {
            if (symbolTable.get(word) > symbolTable.get(max)) {
                max = word;
            }
        }

        return max;
    }
}
