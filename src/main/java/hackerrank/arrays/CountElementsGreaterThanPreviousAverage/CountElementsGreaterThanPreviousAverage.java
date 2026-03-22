package hackerrank.arrays.CountElementsGreaterThanPreviousAverage;

import java.util.List;

public class CountElementsGreaterThanPreviousAverage {

    /**
     * Given an array of positive integers, return the number of elements
     * that are strictly greater than the average of all previous elements.
     * The first element is skipped.
     *
     * Time complexity:  O(n)
     * Space complexity: O(1)
     *
     * @param responseTimes list of positive integers
     * @return count of elements greater than the average of all previous elements
     */
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {

        if (responseTimes.isEmpty()) {
            return 0;
        }

        Integer firstElement = responseTimes.get(0);

        double[] sum = { firstElement };
        double[] count = { 1 };
        double[] greaterThan = { 0 };

        responseTimes.stream()
            .skip(1)
            .forEach(e -> {
                double avg = sum[0] / count[0];
                if (e > avg) {
                    greaterThan[0]++;
                }
                sum[0] += e;
                count[0]++;
            });

        return (int) greaterThan[0];
    }
}
