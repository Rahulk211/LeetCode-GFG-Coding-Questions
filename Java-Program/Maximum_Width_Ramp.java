/*
 * A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
 *  The width of such a ramp is j - i.
 * Given an integer array nums, return the maximum width of a ramp in nums. 
 * If there is no ramp in nums, return 0.
 * 
 */

import java.util.Scanner;
import java.util.Stack;

public class Maximum_Width_Ramp {

    private static int maxWidthRamp(int[] nums){
        int maxRamp = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(stk.isEmpty() || nums[stk.peek()]>nums[i]){
                stk.push(i);
            }
        }

        for(int i =nums.length-1;i>=0;i--){
            while(!stk.isEmpty() && nums[stk.peek()]<=nums[i]){
                maxRamp = Math.max(maxRamp,i-stk.pop());
            }
            if(stk.isEmpty()){
                break;
            }
        }

        return maxRamp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] nums = new int[t];
        for(int i=0;i<t;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(maxWidthRamp(nums));
    }
}
