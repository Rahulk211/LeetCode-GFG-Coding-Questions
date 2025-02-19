// import java.util.ArrayDeque;
// import java.util.Deque;

public class MaximumSumofDistinctSubarraysWithLengthK {

    private static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long windowSum = 0;
        int i = 0, j = 1;
        int curr = nums[0];
        while (j < n) {
            if (nums[j] == curr) {
                curr = nums[j];
                windowSum = 0;
                i++;
                j++;
            } else {
                windowSum += curr;
                if (j - i + 1 < k) {
                    continue;
                }
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i];
                i++;
                j++;
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }

}
