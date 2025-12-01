public class MaximumSubarraySumWithLengthDivisiblebyK {

    private static int maxSubarraySum(int[] nums, int k){
        int n = nums.length;
        int[] prefixsum = new int[k];
        prefixsum[0] = 0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            int len = i+1;
            int mod = len % k;
            if(prefixsum[mod] == 0 && mod != 0){
                prefixsum[mod] = sum;
            } else {
                prefixsum[mod] = Math.min(prefixsum[mod], sum);
            }
        }

        return prefixsum[0];
    }
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int k = 4;
        System.out.println(maxSubarraySum(nums, k));
    }
}
