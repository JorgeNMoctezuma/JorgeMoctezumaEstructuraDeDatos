package PuntosExtras;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultArray2D {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= arr.size() - 3; i++) {
            for (int j = 0; j <= arr.get(i).size() - 3; j++) {
                int currentSum = sand(arr, i, j);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    private static int sand(List<List<Integer>> arr, int row, int col) {
        int sum = 0;

        // Top row of the hourglass
        sum += arr.get(row).get(col) + arr.get(row).get(col + 1) + arr.get(row).get(col + 2);

        // Middle of the hourglass
        sum += arr.get(row + 1).get(col + 1);

        // Bottom row of the hourglass
        sum += arr.get(row + 2).get(col) + arr.get(row + 2).get(col + 1) + arr.get(row + 2).get(col + 2);

        return sum;
    }



}

public class Array2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultArray2D.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
