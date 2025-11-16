import java.util.Scanner;

public class FindtheMaximumLengthofValidSubsequence_II {

    private static int maximumLength(int[] nums, int k){
        // int n = nums.length;
        int maxLen = 0;

        for(int i=0;i<k;i++){
            int[] dp = new int[k];
            for(int num : nums){
                int rem = num % k;
                int need = (i - rem + k) % k;
                int newl = dp[need]+1;
                dp[rem] = Math.max(dp[rem], newl);
                maxLen = Math.max(maxLen, dp[rem]);
            }
        }

        return maxLen >= 2 ? maxLen : 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        System.out.println(maximumLength(nums, k));
    }
}
