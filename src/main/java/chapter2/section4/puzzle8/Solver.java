package chapter2.section4.puzzle8;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Solver {

    private static final Comparator<Node> MANHATTAN_ORDER = new ManhattanComparator();

    private final Stack<Board> steps;

    private final boolean isSolvable;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) {
            throw new IllegalArgumentException();
        }

        steps = new Stack<>();
        final MinPQ<Node> queue = new MinPQ<>(MANHATTAN_ORDER);
        final Node initialNode = new Node(initial, 0, null);
        final Node twinNode = new Node(initial.twin(), 0, null);

        queue.insert(initialNode);
        queue.insert(twinNode);

        while (queue.min() != null
                && !queue.min().board.isGoal()) {
            final Node node = queue.delMin();
            if (node == null) {
                break;
            }

            for (Board neighbor : node.board.neighbors()) {
                if (node.prev != null && node.prev.board.equals(neighbor)) {
                    continue;
                }
                final Node neighborNode = new Node(neighbor, node.moves + 1, node);
                queue.insert(neighborNode);
            }
        }

        Node node = queue.delMin();
        do {
            if (node == null) {
                break;
            }

            steps.push(node.board);
            node = node.prev;
        } while (node != null);

        isSolvable = initial.equals(steps.peek());
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable) {
            return -1;
        }
        return steps.size() - 1;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable) {
            return null;
        }
        return steps;
    }

    private static class Node {

        final Board board;

        final int moves;

        final int priority;

        final Node prev;

        Node(Board board, int moves, Node prev) {
            this.board = board;
            this.moves = moves;
            this.priority = board.manhattan();
            this.prev = prev;
        }
    }

    private static class ManhattanComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            final int order = (o1.priority + o1.moves) - (o2.priority + o2.moves);
            if (order == 0) {
                return o1.priority - o2.priority;
            }
            return order;
        }
    }

    // test client
    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
