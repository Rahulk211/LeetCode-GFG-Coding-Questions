import java.util.Arrays;

public class Swap_and_Maximize {

    static long maxSum(long[] nums){
        int n = nums.length;
        Arrays.sort(nums);

        long sum =0;
        for(int i=0;i<n/2;i++){
            sum += 2 * nums[n-i-1];
            sum -= 2 * nums[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        long[] nums = {10, 12};
        System.out.println(maxSum(nums));
    }
}
