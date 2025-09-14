public class LongestSubarrayof1sAfterDeletingOneElement {

    private static int longestSubarray(int[] nums){
        int n = nums.length;
        int max = 0;
        int i=0,j=0;
        int z_cnt = 0;

        while(j<n){
            if(nums[j] == 0) z_cnt++;

            while(z_cnt > 1 && i<n){
                if(nums[i] == 0) z_cnt--;
                //System.out.println(i);
                i++;
            }

            max = Math.max(max, j-i);
            j++;
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};

        System.out.println(longestSubarray(nums));
    }
}
