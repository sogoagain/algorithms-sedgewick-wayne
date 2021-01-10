package chapter2.section2.collinear;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        validPoints(points);
        final Point[] sortedPoints = getSortedPoints(points);
        validDuplicate(sortedPoints);

        for (int i = 0; i < sortedPoints.length - 3; i++) {
            for (int j = i + 1; j < sortedPoints.length - 2; j++) {
                for (int k = j + 1; k < sortedPoints.length - 1; k++) {
                    for (int l = k + 1; l < sortedPoints.length; l++) {
                        final double ij = sortedPoints[i].slopeTo(sortedPoints[j]);
                        final double jk = sortedPoints[j].slopeTo(sortedPoints[k]);
                        final double kl = sortedPoints[k].slopeTo(sortedPoints[l]);

                        if (ij == jk && jk == kl) {
                            segments.add(new LineSegment(sortedPoints[i], sortedPoints[l]));
                        }
                    }
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return segments.size();
    }

    // the line segments
    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[0]);
    }

    private void validPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        for (Point point : points) {
            if (point == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    private Point[] getSortedPoints(Point[] points) {
        final Point[] sortedPoints = new Point[points.length];
        System.arraycopy(points, 0, sortedPoints, 0, points.length);
        Arrays.sort(sortedPoints);
        return sortedPoints;
    }

    private void validDuplicate(Point[] sortedPoints) {
        for (int i = 0; i < sortedPoints.length - 1; i++) {
            if (sortedPoints[i].compareTo(sortedPoints[i + 1]) == 0)
                throw new IllegalArgumentException();
        }
    }
}
