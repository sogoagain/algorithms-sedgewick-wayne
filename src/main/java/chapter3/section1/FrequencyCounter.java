package chapter3.section1;

public class FrequencyCounter {

    private final ST<String, Integer> st;

    public FrequencyCounter(ST<String, Integer> st) {
        this.st = st;
    }

    public String count(int minLength, String texts) {
        for (String text : texts.split("\n")) {
            for (String word : text.split(" ")) {
                if (word.length() < minLength) {
                    continue;
                }
                if (!st.contains(word)) {
                    st.put(word, 1);
                } else {
                    st.put(word, st.get(word) + 1);
                }
            }
        }

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            System.out.println("key: " + word + " ," + "value: " + st.get(word));
            if (st.get(word) > st.get(max)) {
                max = word;
            }
        }

        return max;
    }
}
