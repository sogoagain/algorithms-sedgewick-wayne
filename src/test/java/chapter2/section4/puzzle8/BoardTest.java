package chapter2.section4.puzzle8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private int[][] tiles = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(tiles);
    }

    @Test
    void constructor() {
        assertThat(board).isNotNull();
    }

    @Test
    void stringRepresentation() {
        assertThat(board.toString()).isEqualTo("3\n" +
                " 0  1  3\n" +
                " 4  2  5\n" +
                " 7  8  6");
    }

    @Test
    void dimension() {
        assertThat(board.dimension()).isEqualTo(3);
    }

    @Test
    void hamming() {
        assertThat(board.hamming()).isEqualTo(4);
        final int[][] fourByFour = {{8, 9, 14, 15}, {6, 1, 4, 13}, {2, 5, 7, 0}, {3, 11, 10, 12}};
        assertThat(new Board(fourByFour).hamming()).isEqualTo(15);
    }

    @Test
    void manhattan() {
        assertThat(board.manhattan()).isEqualTo(4);
    }

    @Test
    void isGoal() {
        assertThat(board.isGoal()).isFalse();

        final int[][] goalTiles = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        final Board goal = new Board(goalTiles);
        assertThat(goal.isGoal()).isTrue();
    }

    @Test
    void comparing() {
        final Board same = new Board(tiles);
        assertThat(same).isEqualTo(board);

        final int[][] differentTiles = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        final Board different = new Board(differentTiles);
        assertThat(different).isNotEqualTo(board);
    }

    @Test
    void neighbors() {
        final int[][] neighbor1 = {{1, 0, 3}, {4, 2, 5}, {7, 8, 6}};
        final int[][] neighbor2 = {{4, 1, 3}, {0, 2, 5}, {7, 8, 6}};
        for (Board neighbor : board.neighbors()) {
            assertThat(neighbor).isIn(new Board(neighbor1), new Board(neighbor2));
        }
    }

    @Test
    void twin() {
        final int[][] twin = {{0, 1, 3}, {2, 4, 5}, {7, 8, 6}};
        final Board twinBoard = new Board(twin);
        assertThat(board.twin()).isEqualTo(twinBoard);
    }
}
