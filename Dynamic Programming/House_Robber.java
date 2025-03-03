public class House_Robber {

    private static int rob(int[] nums){
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] nums = {2,7,3,1,4,2,1,8,3};
        System.out.println(rob(nums));
    }
}
