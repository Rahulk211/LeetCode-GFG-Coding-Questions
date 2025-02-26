public class MaximumAbsoluteSumofAnySubarray {

    private static int maxAbsoluteSum(int[] nums){
        int maxPrefixSum = 0;
        int minPrefixSum = 0;

        int sum = 0;

        for(int num : nums){
            sum += num;
            maxPrefixSum = Math.max(maxPrefixSum, sum);
            minPrefixSum = Math.min(minPrefixSum, sum);
        }

        return maxPrefixSum - minPrefixSum;
    }
    public static void main(String[] args) {
        int[] nums = {1,-3,2,3,-4};
        System.out.println(maxAbsoluteSum(nums));
    }
}
