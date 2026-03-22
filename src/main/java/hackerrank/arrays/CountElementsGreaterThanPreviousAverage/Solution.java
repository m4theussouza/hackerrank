package hackerrank.arrays.CountElementsGreaterThanPreviousAverage;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

// =====================================================================
// This file is the HackerRank submission template.
// Copy and paste the contents of Result and Solution into HackerRank.
// The logic lives in CountElementsGreaterThanPreviousAverage.java.
// =====================================================================

class Result {

    /*
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
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

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countResponseTimeRegressions(responseTimes);

        System.out.println(result);

        bufferedReader.close();
    }
}
