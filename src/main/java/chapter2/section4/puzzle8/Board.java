package chapter2.section4.puzzle8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private int[][] tiles;

    private int n;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        n = tiles.length;
        this.tiles = copy(tiles);
    }

    // string representation of this board
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n);

        for (int[] tile : tiles) {
            stringBuilder.append("\n");
            for (int j = 0; j < n; j++) {
                stringBuilder.append(String.format("%2d", tile[j]));
                if (j < n - 1) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }

    // board dimension n
    public int dimension() {
        return n;
    }

    // number of tiles out of place
    public int hamming() {
        int wrongPositionCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int goal = i * n + j + 1;
                if (goal == n * n) {
                    break;
                }
                if (tiles[i][j] != goal) {
                    wrongPositionCount++;
                }
            }
        }
        return wrongPositionCount;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    continue;
                }
                int goal = i * n + j + 1;
                if (tiles[i][j] != goal) {
                    int row = Math.abs(((tiles[i][j] - 1) / n) - i);
                    int col = Math.abs(((tiles[i][j] - 1) % n) - j);
                    sum += row + col;
                }
            }
        }
        return sum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        return hamming() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Board board = (Board) o;
        return n == board.n &&
                Arrays.deepEquals(tiles, board.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        final List<Board> neighbors = new ArrayList<>();
        final int[] blankPosition = getBlankPosition();
        final int row = blankPosition[0];
        final int col = blankPosition[1];

        if (row > 0) {
            neighbors.add(swappedBoard(row, col, row - 1, col));
        }

        if (row < n - 1) {
            neighbors.add(swappedBoard(row, col, row + 1, col));
        }

        if (col > 0) {
            neighbors.add(swappedBoard(row, col, row, col - 1));
        }

        if (col < n - 1) {
            neighbors.add(swappedBoard(row, col, row, col + 1));
        }

        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles

    public Board twin() {
        if (tiles[0][0] == 0 || tiles[0][1] == 0) {
            return swappedBoard(1, 0, 1, 1);
        }
        return swappedBoard(0, 0, 0, 1);
    }

    private int[] getBlankPosition() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    private Board swappedBoard(int row1, int col1, int row2, int col2) {
        final int[][] copiedTiles = copy(tiles);
        return new Board(swap(copiedTiles, row1, col1, row2, col2));
    }

    private int[][] copy(int[][] arr) {
        final int[][] copied = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copied[i] = new int[arr[i].length];
            System.arraycopy(arr[i], 0, copied[i], 0, arr.length);
        }
        return copied;
    }

    private int[][] swap(int[][] tiles, int row1, int col1, int row2, int col2) {
        final int temp = tiles[row1][col1];
        tiles[row1][col1] = tiles[row2][col2];
        tiles[row2][col2] = temp;
        return tiles;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    }
}
