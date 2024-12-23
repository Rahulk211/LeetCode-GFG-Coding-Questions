public class TwoSmallestsinEverySubarray {

    private static int pairWithMaxSum(int[] nums){
        if(nums.length <= 1){
            return -1;
         }
         int max =0;
        for(int i=0;i<nums.length-1;i++){
            int sum = nums[i]+nums[i+1];
            max = Math.max(sum,max);
        }
        
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {9, 2, 3, 2, 5, 2, 8};
        System.out.println(pairWithMaxSum(nums));
    }
}
