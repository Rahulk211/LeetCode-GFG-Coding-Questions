
import java.util.Scanner;

public class Maximum_Swap {

    private static int maximumSwap(int num){
        char[] nums = Integer.toString(num).toCharArray();
        char max_ele = nums[nums.length-1];
        int max_idx = nums.length-1;
        int idx1 = -1;
        int idx2 = -1;

        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] > max_ele){
                max_ele = nums[i];
                max_idx = i;
            }
            else if(nums[i] < max_ele ){
                idx1 = i;
                idx2 = max_idx;
            }
            
        }
        if(idx1!=-1){
            char temp = nums[idx1]; 
            nums[idx1] = nums[idx2];
            nums[idx2] = temp;
        }
        return Integer.parseInt(new String(nums));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = sc.nextInt();
        sc.close();

        System.out.println(maximumSwap(num));
    }
}
