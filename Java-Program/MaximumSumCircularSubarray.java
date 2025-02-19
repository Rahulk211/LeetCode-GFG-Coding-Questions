public class MaximumSumCircularSubarray {

    // A circular array means the end of the array connects to the beginning of the array.
    //  Formally, the next element of nums[i] is nums[(i + 1) % n] 
    // and the previous element of nums[i] is nums[(i - 1 + n) % n].

    private static int maxSubarraySumCircular(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }

        // Find the maximum sum of a subarray using Kadane's algorithm
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }

        // Find the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Find the minimum sum of a subarray using Kadane's algorithm
        int minSum = Integer.MAX_VALUE;
        currSum = 0;
        for (int num : nums) {
            currSum = Math.min(num, currSum + num);
            minSum = Math.min(minSum, currSum);
        }

        // If the total sum is equal to the minimum sum, it means all numbers are negative
        if (totalSum == minSum) {
            return maxSum;
        }

        // Return the maximum of the maximum sum of a subarray and the total sum minus the minimum sum of a subarray
        return Math.max(maxSum, totalSum - minSum);
    }
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
