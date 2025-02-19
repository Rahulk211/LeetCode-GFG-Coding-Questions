public class TargetSum {

    private static int helper(int[] nums, int idx, int sum, int target){
        if(idx == nums.length){
            return sum==target?1:0;
        }
        int add = helper(nums, idx+1, sum+nums[idx], target);
        int sub = helper(nums, idx+1, sum-nums[idx], target);

        return add+sub;
    }

    private static int findTargetSumWays(int[] nums, int target){
        return helper(nums,0,0,target);
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
    
}
