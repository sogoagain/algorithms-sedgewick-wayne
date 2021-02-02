package chapter3.section1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SequentialSearchSTTest {

    @Test
    void indexing() {
        final ST<String, Integer> st = new SequentialSearchST<>();
        final SymbolTableTestClient testClient = new SymbolTableTestClient(st);

        final String result = testClient.indexing("S E A R C H E X A M P L E");

        assertThat(result).isEqualTo("L 11\n" +
                "P 10\n" +
                "M 9\n" +
                "X 7\n" +
                "H 5\n" +
                "C 4\n" +
                "R 3\n" +
                "A 8\n" +
                "E 12\n" +
                "S 0\n");
    }

    @Test
    void frequencyCounter() {
        final ST<String, Integer> st = new SequentialSearchST<>();
        final FrequencyCounter counter = new FrequencyCounter(st);

        final String texts = "it was the best of times it was tie worst of times\n" +
                "it was the age of wisdom it was the age of foolishness\n" +
                "it was the epoch of belief it was the epoch of incredulity\n" +
                "it was the season of light it was the season of darkness\n" +
                "it was the spring of hope it was the winter of despair\n" +
                "it ...";

        final String max = counter.count(1, texts);

        assertThat(max).isEqualTo("it");
    }
}
