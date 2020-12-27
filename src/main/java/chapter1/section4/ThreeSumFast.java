package chapter1.section4;

import chapter1.section1.BinarySearch;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a) {
        final int[] sortedArr = Arrays.copyOf(a, a.length);
        Arrays.sort(sortedArr);

        int count = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            for (int j = i + 1; j < sortedArr.length; j++) {
                if (BinarySearch.rank(-(sortedArr[i] + sortedArr[j]), sortedArr) > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
