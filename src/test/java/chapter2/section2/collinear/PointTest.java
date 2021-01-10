package chapter2.section2.collinear;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void compareTo() {
        final Point point1 = new Point(1, 2);
        final Point point2 = new Point(3, 5);
        final Point point3 = new Point(2, 1);

        assertThat(point1.compareTo(point2)).isNegative();
        assertThat(point1.compareTo(point3)).isPositive();
        assertThat(point2.compareTo(point3)).isPositive();
    }

    @Test
    void slopeTo() {
        final Point point1 = new Point(1, 2);
        final Point point2 = new Point(3, 5);
        assertThat(point1.slopeTo(point2)).isEqualTo(1.5);

        final Point point3 = new Point(2, 2);
        assertThat(point1.slopeTo(point3)).isEqualTo(0.0);

        final Point point4 = new Point(1, 3);
        assertThat(point1.slopeTo(point4)).isEqualTo(Double.POSITIVE_INFINITY);

        final Point point5 = new Point(1, 1);
        assertThat(point1.slopeTo(point5)).isEqualTo(Double.POSITIVE_INFINITY);
        assertThat(point1.slopeTo(point1)).isEqualTo(Double.NEGATIVE_INFINITY);

        final Point point6 = new Point(453, 378);
        final Point point7 = new Point(119, 378);
        assertThat(point6.slopeTo(point7)).isEqualTo(+0.0);
    }

    @Test
    void slopOrder() {
        final Point[] points = new Point[]{
                new Point(1, 2),
                new Point(3, 5),
                new Point(2, 1)
        };
        final Point[] sortedPoints = new Point[points.length];
        System.arraycopy(points, 0, sortedPoints, 0, points.length);

        Arrays.sort(points, points[points.length - 1].slopeOrder());

        assertThat(sortedPoints[2]).isEqualTo(points[0]);
    }
}
