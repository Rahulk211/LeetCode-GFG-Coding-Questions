import java.util.Arrays;

public class MaximumBeautyofanArrayAfterApplyingOperation {

    private static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int win_len = 0;
        int max_len = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] - nums[l] <= 2 * k) {
                win_len += 1;
                r++;
            }

            max_len = Math.max(max_len, win_len);
            if(r==nums.length) break;
            while(l<=r && nums[r]-nums[l]>2*k){
                win_len-=1;
                l++;
            }

        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1 };
        int k = 10;

        System.out.println(maximumBeauty(nums, k));
    }

}
