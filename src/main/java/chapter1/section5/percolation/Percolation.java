package chapter1.section5.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int size;

    private final boolean[][] sites;

    private final WeightedQuickUnionUF percolationUf;

    private final WeightedQuickUnionUF topUf;

    private int openedCount;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        size = n;
        sites = new boolean[size][size];
        percolationUf = new WeightedQuickUnionUF(n * n + 2);
        topUf = new WeightedQuickUnionUF(n * n + 1);
        openedCount = 0;
    }

    public void open(int row, int col) {
        checkRange(row, col);

        if (isOpen(row, col)) {
            return;
        }

        sites[row - 1][col - 1] = true;
        if (row == 1) {
            connectTop(row, col);
        }
        if (row == size) {
            connectBottom(row, col);
        }
        connectNeighbors(row, col);
        openedCount++;
    }

    public boolean isOpen(int row, int col) {
        checkRange(row, col);
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        checkRange(row, col);
        return isOpen(row, col) && topUf.find(index(row, col)) == topUf.find(0);
    }

    public int numberOfOpenSites() {
        return openedCount;
    }

    public boolean percolates() {
        return percolationUf.find(0) == percolationUf.find(size * size + 1);
    }

    private void checkRange(int row, int col) {
        if (!isValidRange(row, col)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(int row, int col) {
        return row >= 1 && row <= size && col >= 1 && col <= size;
    }

    private void connectBottom(int row, int col) {
        percolationUf.union(index(row, col), size * size + 1);
    }

    private void connectTop(int row, int col) {
        percolationUf.union(index(row, col), 0);
        topUf.union(index(row, col), 0);
    }

    private void connectNeighbors(int row, int col) {
        connect(row, col, row, col - 1);
        connect(row, col, row, col + 1);
        connect(row, col, row - 1, col);
        connect(row, col, row + 1, col);
    }

    private void connect(int row1, int col1, int row2, int col2) {
        if (!isValidRange(row1, col1) || !isOpen(row1, col1)
                || !isValidRange(row2, col2) || !isOpen(row2, col2)) {
            return;
        }
        percolationUf.union(index(row1, col1), index(row2, col2));
        topUf.union(index(row1, col1), index(row2, col2));
    }

    private int index(int row, int col) {
        return (row - 1) * size + col;
    }

    public static void main(String[] args) {
    }
}
