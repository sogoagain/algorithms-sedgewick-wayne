package chapter2.section2.collinear;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FastCollinearPointsTest {

    @Test
    void cornerCase() {
        assertThatThrownBy(() -> new FastCollinearPoints(null))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new FastCollinearPoints(new Point[]{null}))
                .isExactlyInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new FastCollinearPoints(new Point[]{new Point(1, 2), new Point(1, 2)}))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void client() {
        final Point[] points = new Point[8];
        points[0] = new Point(10000, 0);
        points[1] = new Point(0, 10000);
        points[2] = new Point(3000, 7000);
        points[3] = new Point(7000, 3000);
        points[4] = new Point(20000, 21000);
        points[5] = new Point(3000, 4000);
        points[6] = new Point(14000, 15000);
        points[7] = new Point(6000, 7000);

        final FastCollinearPoints collinear = new FastCollinearPoints(points);

        assertThat(collinear.numberOfSegments()).isEqualTo(2);

        final LineSegment[] segments = collinear.segments();

        assertThat(segments[0].toString()).isEqualTo("(10000, 0) -> (0, 10000)");
        assertThat(segments[1].toString()).isEqualTo("(3000, 4000) -> (20000, 21000)");
    }

    @Test
    void client2() {
        final Point[] points = new Point[]{
                new Point(16000, 16000),
        };

        final FastCollinearPoints collinear = new FastCollinearPoints(points);

        assertThat(collinear.numberOfSegments()).isEqualTo(0);
    }
}
