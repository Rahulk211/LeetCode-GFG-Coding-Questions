public class RotateArray {
    public static void rotate(int[] nums,int k){
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1); 
    }

    public static void reverse(int[] nums, int s, int e){
        while (s<e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        //int n = nums.length;
        int k = 3;
        rotate(nums,k);

        for(int num : nums){
            System.out.println(num+" ");
        }

    }
    
}
