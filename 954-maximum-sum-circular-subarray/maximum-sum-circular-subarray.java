class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currMax = nums[0];
        int maxSum = nums[0];

        int currMin = nums[0];
        int minSum = nums[0];

        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Normal Kadane
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum = Math.max(maxSum, currMax);

            // Minimum subarray Kadane
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum = Math.min(minSum, currMin);

            // Total sum
            total += nums[i];
        }

        // If all elements are negative,
        // total - minSum would represent an empty subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        int circularSum = total - minSum;

        return Math.max(maxSum, circularSum);
    }
}