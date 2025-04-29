public class CountSubarraysWithFixedBounds {
    private static int countSubarrays(int[] nums, int mink, int maxk){
        int n = nums.length;
        int mink_idx = -1;
        int maxk_idx = -1;
        int count = 0;
        int invalid_idx = -1;

        for(int i=0;i<n;i++){
            if(nums[i] == mink){
                mink_idx = i;
            }
            if(nums[i] == maxk){
                maxk_idx = i;
            }
            if(nums[i] < mink || nums[i] > maxk){
                invalid_idx = i;
            }
            if(mink_idx != -1 && maxk_idx != -1){
                count += Math.max(Math.min(mink_idx,maxk_idx) - invalid_idx, 0);
            }
            
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {4,3};
        int mink = 3;
        int maxk = 3;

        System.out.println(countSubarrays(nums, mink, maxk));
    }
}
