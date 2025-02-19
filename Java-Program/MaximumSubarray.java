import java.util.Scanner;

public class MaximumSubarray {

    private static int maximumSum(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int curr_sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curr_sum > 0){
                curr_sum += nums[i];
            }
            else{
                curr_sum = nums[i];
            }
            maxSum = Math.max(curr_sum,maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        
        System.out.println(maximumSum(nums));
    }
    
}
