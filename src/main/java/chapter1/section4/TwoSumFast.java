package chapter1.section4;

import chapter1.section1.BinarySearch;

import java.util.Arrays;

public class TwoSumFast {

    public static int count(int[] arr) {
        final int[] sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);

        int count = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            if (BinarySearch.rank(-sortedArr[i], sortedArr) > i) {
                count++;
            }
        }
        return count;
    }
}
