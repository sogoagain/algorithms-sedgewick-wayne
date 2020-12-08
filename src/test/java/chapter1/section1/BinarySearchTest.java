package chapter1.section1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    @Test
    void rank() {
        final int[] whitelist = {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 48, 33, 16, 77, 11, 29};
        final int[] testcase = {23, 50, 10, 99, 18, 23, 98, 84, 11, 10, 48, 77, 13, 54, 98, 77, 77, 68};
        final List<Integer> notFoundList = new ArrayList<>();

        Arrays.sort(whitelist);
        for (int value : testcase) {
            final int index = BinarySearch.rank(value, whitelist);
            if (index == -1) {
                notFoundList.add(value);
            }
        }

        assertThat(notFoundList).containsExactly(50, 99, 13);
    }
}
