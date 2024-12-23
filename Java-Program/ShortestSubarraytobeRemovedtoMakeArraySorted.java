import java.util.Scanner;
import java.util.Stack;

public class ShortestSubarraytobeRemovedtoMakeArraySorted {

    private static int findLengthOfShortestSubarray(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                stk.push(nums[i]);
            }
        }

        return n-stk.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();

        System.out.println(findLengthOfShortestSubarray(arr));
    }
    
}
