import java.util.ArrayDeque;
//import java.util.ArrayList;
import java.util.Deque;
//import java.util.List;
import java.util.Scanner;

public class FindthePowerofK_SizeSubarrays_I {

    private static int[] resultsArray(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        // List<Integer> res = new ArrayList<>();
        int[] res = new int[n-k+1];
        int j=0;
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<= i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] != nums[i]-1){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=k-1){
                if(dq.size() == k)  {
                    res[j] = (nums[dq.peekLast()]);
                }
                else{
                    res[j] = -1;
                }
                j++;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = Sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the elements of array : ");
            arr[i] = Sc.nextInt();
        }
        int k = Sc.nextInt();
        Sc.close();

        int[] res = resultsArray(arr, k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
    
}
