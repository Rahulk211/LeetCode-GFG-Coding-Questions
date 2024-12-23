import java.util.Scanner;

public class CountNumberofMaximumBitwise_ORSubsets {

    private static int countMaxOrSubsets(int[] nums){
        int n = nums.length;
        int target_or =0;
        for(int i=0;i<n;i++){
            target_or |= nums[i];
        }
        // memorise the calculated states
        Integer dp[][] = new Integer[n][target_or+1];

        return subsetsOr(0,nums,0,target_or,dp);
    }
    
    private static int subsetsOr(int index,int[] nums,int current_or,int target_or, Integer dp[][]){
        if(index == nums.length){
            return current_or == target_or?1:0;
        }
        if(dp[index][current_or] !=null){
            return dp[index][current_or];
        }

        //pick 
        int pick = subsetsOr(index+1,nums,current_or|nums[index],target_or,dp);
        //nopick
        int nopick = subsetsOr(index+1,nums,current_or,target_or,dp);

        return dp[index][current_or] = pick +nopick;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(countMaxOrSubsets(nums));
    }   
}
