package hackerrank.arrays.CountElementsGreaterThanPreviousAverage;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static hackerrank.arrays.CountElementsGreaterThanPreviousAverage.CountElementsGreaterThanPreviousAverage.countResponseTimeRegressions;

public class CountElementsGreaterThanPreviousAverageTest {

    @Test
    public void testExampleCase() {
        // [100, 200, 150, 300] → 2
        assertEquals(2, countResponseTimeRegressions(List.of(100, 200, 150, 300)));
    }

    @Test
    public void testEmptyList() {
        // empty list → 0
        assertEquals(0, countResponseTimeRegressions(List.of()));
    }

    @Test
    public void testSingleElement() {
        // single element, nothing to compare → 0
        assertEquals(0, countResponseTimeRegressions(List.of(100)));
    }

    @Test
    public void testAllEqual() {
        // [5, 5, 5, 5] → none is strictly greater → 0
        assertEquals(0, countResponseTimeRegressions(List.of(5, 5, 5, 5)));
    }

    @Test
    public void testAllIncreasing() {
        // [1, 2, 3, 4] → all greater than previous average
        assertEquals(3, countResponseTimeRegressions(List.of(1, 2, 3, 4)));
    }

    @Test
    public void testAllDecreasing() {
        // [100, 50, 25] → none greater than previous average → 0
        assertEquals(0, countResponseTimeRegressions(List.of(100, 50, 25)));
    }

    @Test
    public void testLargeValues() {
        // tests for potential overflow with large values (up to 10^9)
        assertEquals(0, countResponseTimeRegressions(List.of(1_000_000_000, 1_000_000_000, 1_000_000_000)));
    }

    @Test
    public void testTwoElementsGreater() {
        // [10, 20] → 20 > avg(10) = 10 → 1
        assertEquals(1, countResponseTimeRegressions(List.of(10, 20)));
    }

    @Test
    public void testTwoElementsSmaller() {
        // [20, 10] → 10 > avg(20) = 20 → 0
        assertEquals(0, countResponseTimeRegressions(List.of(20, 10)));
    }

    @Test
    public void testElementEqualToAverage() {
        // [10, 20, 15] → 15 == avg(10, 20) = 15 → not strictly greater → 1
        assertEquals(1, countResponseTimeRegressions(List.of(10, 20, 15)));
    }
}
