public class  MaxConsecutiveOnes_III{

    private static int longestOnes(int[] nums, int k){
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int z_cnt = 0;
        while(r < n){
            if(nums[r] == 0){
                z_cnt++;
            }
            while(z_cnt>k){
                if(nums[l] == 0){
                    z_cnt--;
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }

}