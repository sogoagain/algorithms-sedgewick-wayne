package chapter1.section5.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONFIDENCE_INTERVAL = 1.96;

    private final double[] fractions;

    private final int trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        fractions = new double[trials];
        this.trials = trials;

        for (int i = 0; i < this.trials; i++) {
            experiment(n, i);
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        if (trials == 1) {
            return Double.NaN;
        }
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
        return mean() - ((CONFIDENCE_INTERVAL * stddev()) / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + ((CONFIDENCE_INTERVAL * stddev()) / Math.sqrt(trials));
    }

    private void experiment(int n, int i) {
        final Percolation percolation = new Percolation(n);

        while (!percolation.percolates()) {
            int row = StdRandom.uniform(1, n + 1);
            int col = StdRandom.uniform(1, n + 1);
            percolation.open(row, col);
        }

        fractions[i] = (double) percolation.numberOfOpenSites() / (n * n);
    }

    public static void main(String[] args) {
        final int size = Integer.parseInt(args[0]);
        final int trials = Integer.parseInt(args[1]);
        final PercolationStats pStats = new PercolationStats(size, trials);

        StdOut.println("mean                    = " + pStats.mean());
        StdOut.println("stddev                  = " + pStats.stddev());
        StdOut.println("95% confidence interval = [" + pStats.confidenceLo() + ", " + pStats.confidenceHi() + "]");
    }
}
