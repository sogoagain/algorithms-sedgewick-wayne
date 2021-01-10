package chapter2.section2.collinear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

    private ArrayList<LineSegment> segments = new ArrayList<>();

    // finds all line segments containing 4 points
    public FastCollinearPoints(Point[] points) {
        validPoints(points);
        final Point[] sortedPoints = getSortedPoints(points);
        validDuplicate(sortedPoints);

        if (sortedPoints.length < 4) {
            return;
        }

        final Point[] pointsSortedBySlopes = getPointsSortedBySlopes(sortedPoints);
        for (Point point : sortedPoints) {
            Arrays.sort(pointsSortedBySlopes, point.slopeOrder());
            int start = 1;
            double slope = point.slopeTo(pointsSortedBySlopes[start]);

            for (int i = 2; i < pointsSortedBySlopes.length; i++) {
                final double slopeTemp = point.slopeTo(pointsSortedBySlopes[i]);
                if (slopeTemp == slope) {
                    continue;
                }

                drawLineWhen4orMorePoints(pointsSortedBySlopes, point, start, i - 1);
                slope = slopeTemp;
                start = i;
            }
            drawLineWhen4orMorePoints(pointsSortedBySlopes, point, start, sortedPoints.length - 1);
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

    private Point[] getPointsSortedBySlopes(Point[] points) {
        final Point[] pointsSortedBySlopes = new Point[points.length];
        System.arraycopy(points, 0, pointsSortedBySlopes, 0, points.length);
        return pointsSortedBySlopes;
    }

    private void drawLineWhen4orMorePoints(Point[] pointsSortedBySlopes, Point point, int start, int end) {
        int pointsCount = (end - start + 1) + 1;
        if (pointsCount >= 4) {
            final Point[] endPoints = getEndPoints(pointsSortedBySlopes, point, start, end);
            if (point.compareTo(endPoints[0]) == 0) {
                segments.add(new LineSegment(endPoints[0], endPoints[1]));
            }
        }
    }

    private Point[] getEndPoints(Point[] pointsSortedBySlopes, Point origin, int startIndex, int end) {
        final List<Point> points = new ArrayList<>();
        points.add(origin);
        points.addAll(Arrays.asList(pointsSortedBySlopes).subList(startIndex, end + 1));
        points.sort(null);
        return new Point[]{points.get(0), points.get(points.size() - 1)};
    }
}
