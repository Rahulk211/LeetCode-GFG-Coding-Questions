package Stack;

import java.util.Stack;

public class MinimumOperationstoConvertAllElementstoZero {

    private static int minOperations(int[] nums){
        int cnt=0;
        Stack<Integer> stk = new Stack<>();
        
        for(int n : nums){
            if(n==0) continue;
            while(!stk.isEmpty() && stk.peek()>n){
                stk.pop();
            }
            if(stk.isEmpty() || stk.peek()<n){
                cnt++;
                stk.push(n);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {7,2,0,4,2};
        System.out.println(minOperations(nums));
    }
}
