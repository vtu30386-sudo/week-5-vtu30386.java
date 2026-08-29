import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function returns an INTEGER_ARRAY.
     * It returns:
     * 1. Maximum contiguous subarray sum
     * 2. Maximum non-contiguous subsequence sum
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // Maximum contiguous subarray sum - Kadane's Algorithm
        int currentSum = arr.get(0);
        int maxSubarraySum = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int num = arr.get(i);

            currentSum = Math.max(num, currentSum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);
        }

        // Maximum non-contiguous subsequence sum
        int maxSubsequenceSum = 0;
        int maxElement = arr.get(0);

        for (int num : arr) {
            if (num > 0) {
                maxSubsequenceSum += num;
            }

            maxElement = Math.max(maxElement, num);
        }

        // If all elements are negative
        if (maxSubsequenceSum == 0) {
            maxSubsequenceSum = maxElement;
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH"))
                );

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine()
                    .replaceAll("\\s+$", "")
                    .split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            List<Integer> result = Result.maxSubarray(arr);

            for (int i = 0; i < result.size(); i++) {
                bufferedWriter.write(String.valueOf(result.get(i)));

                if (i != result.size() - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}