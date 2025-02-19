import java.util.Scanner;

public class TrappingRainWater {

    public static int trappedWater(int[] nums){
        int left=0, right =nums.length-1;
        int total=0;
        int leftmax=0,rightmax=0;

        while(left<right){
            if(nums[left]<=nums[right]){
                if(leftmax > nums[left]){
                    total+=leftmax-nums[left];
                }
                else{
                    leftmax=nums[left];
                }
                left++;
            }
            else{
                if(rightmax > nums[right]){
                    total +=rightmax-nums[right];
                }
                else{
                    rightmax = nums[right];
                }
                right--;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i]=sc.nextInt();
        }
        sc.close();

        System.out.println(trappedWater(nums));
    }
}
