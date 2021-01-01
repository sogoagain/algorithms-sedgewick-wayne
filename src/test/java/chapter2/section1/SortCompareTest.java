package chapter2.section1;

import org.junit.jupiter.api.Test;

class SortCompareTest {

    @Test
    void InsertionVsSelection() {
        final int N = 1000;
        final int T = 100;
        final String alg1 = "Insertion";
        final String alg2 = "Selection";

        compare(N, T, alg1, alg2);
    }

    @Test
    void ShellVsInsertion() {
        final int N = 1000;
        final int T = 100;
        final String alg1 = "Shell";
        final String alg2 = "Insertion";

        compare(N, T, alg1, alg2);
    }

    private void compare(int n, int t, String alg1, String alg2) {
        final double t1 = SortCompare.timeRandomInput(alg1, n, t);
        final double t2 = SortCompare.timeRandomInput(alg2, n, t);

        System.out.printf("For %d random Doubles\n %s is", n, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }
}
