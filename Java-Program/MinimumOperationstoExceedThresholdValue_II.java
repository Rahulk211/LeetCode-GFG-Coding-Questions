import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumOperationstoExceedThresholdValue_II{

    private static int minOperations(int[] nums, int k){
        if(nums.length<2){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        
        int minOperations=0;
        while(pq.peek()<k){
            int top1 = pq.poll();
            int top2 = pq.poll();
            minOperations+=1;
            pq.add((Math.min(top1,top2)*2)+Math.max(top1,top2));
        }
        return minOperations; // Placeholder return value
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k =sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        sc.close();

        System.out.println(minOperations(nums,k));
    }
}