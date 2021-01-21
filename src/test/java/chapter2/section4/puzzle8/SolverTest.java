package chapter2.section4.puzzle8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolverTest {

    private Solver solver;

    private Board goal;

    @BeforeEach
    void setUp() {
        final int[][] goalTiles = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        goal = new Board(goalTiles);
    }

    @Test
    void solvable() {
        final int[][] tiles = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        final Board board = new Board(tiles);

        solver = new Solver(board);

        assertThat(solver.isSolvable()).isTrue();
        assertThat(solver.moves()).isEqualTo(4);

        int stepCount = 0;
        for (Board step : solver.solution()) {
            if (stepCount == 0) {
                assertThat(step).isEqualTo(board);
            }
            if (stepCount == solver.moves()) {
                assertThat(step).isEqualTo(goal);
            }
            stepCount++;
        }
    }

    @Test
    void unsolvable() {
        final int[][] tiles = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
        final Board board = new Board(tiles);

        solver = new Solver(board);

        assertThat(solver.isSolvable()).isFalse();
    }
}
