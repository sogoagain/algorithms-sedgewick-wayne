package chapter1.section5.percolation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PercolationStatsTest {

    private static PercolationStats percolationStats;

    @BeforeAll
    public static void init() {
        percolationStats = new PercolationStats(20, 10);
    }

    @Test
    void mean() {
        System.out.println(percolationStats.mean());
    }

    @Test
    void stddev() {
        System.out.println(percolationStats.stddev());
    }

    @Test
    void confidenceLo() {
        System.out.println(percolationStats.confidenceLo());
    }

    @Test
    void confidenceHi() {
        System.out.println(percolationStats.confidenceHi());
    }
}
