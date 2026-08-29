class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currentMax = 0;
        int maxSum = nums[0];

        int currentMin = 0;
        int minSum = nums[0];

        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // If all elements are negative, return the maximum element
        if (maxSum < 0) {
            return maxSum;
        }

        // Maximum of:
        // 1. Normal maximum subarray
        // 2. Circular subarray = totalSum - minimum subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}