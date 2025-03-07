import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int findLen(int[] nums,int idx, int prev_idx,int[][] dp){
        if(idx == nums.length) return 0;
        if(dp[idx][prev_idx+1] !=-1){
            return dp[idx][prev_idx+1];
        }

        int not_taken = 0+findLen(nums,idx+1, prev_idx,dp);
        int taken = 0;
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            taken =  1+findLen(nums,idx+1,idx,dp);
        }

        dp[idx][prev_idx+1] = Math.max(taken,not_taken);
        return dp[idx][prev_idx];
    }
    private static int lengthOfLIS(int[] nums){
        // int n = nums.length;
        // int[] dp = new int[n];
        // dp[0] = 1;
        // int idx=0;
        // for(int i=1;i<n;i++){
        //     if(nums[i]>nums[i-1]){
        //         dp[i] = dp[i-1]+1;
        //         idx=i;
        //     }
        //     else{
        //         dp[i] = dp[i-1];
        //     }
        // }
        // return dp[n-1];
        int[][] dp = new int[nums.length][nums.length+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return findLen(nums,0, -1,dp);
    }
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }
}
