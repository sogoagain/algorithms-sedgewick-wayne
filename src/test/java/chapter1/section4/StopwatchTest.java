package chapter1.section4;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StopwatchTest {

    @Test
    @Disabled
    void elapsedTime() throws InterruptedException {
        final Stopwatch stopwatch = new Stopwatch();
        Thread.sleep(100);
        final double elapsedTime = stopwatch.elapsedTime();

        assertThat(elapsedTime).isCloseTo(0.1, Percentage.withPercentage(5));
    }
}
