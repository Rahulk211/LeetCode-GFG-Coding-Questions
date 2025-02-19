import java.util.PriorityQueue;
import java.util.Scanner;

public class Maximal_Score_After_Applying_K_Operations {

    private static long maxKelements(int[] nums, int k){
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        long score = 0;
        for(int i=0;i<nums.length;i++){
           int[] num = {nums[i],i};
           maxHeap.add(num);
        }

        while(k>0){
            int[] top = maxHeap.poll();
            score += top[0];
            nums[top[1]] = ceil(top[0],3);
            maxHeap.offer(new int[]{nums[top[1]],top[1]});
            k--;
        }

        return score;
    }

    private static int ceil(int num,int dem){
        return (num/dem) + ((num%dem)!=0?1:0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no. of operations");
        int k = sc.nextInt();
        // System.out.println("enter the sizeOf nums");
        // int n = sc.nextInt();
        int[] nums = {1,10,3,3,3};
        // for(int i=0;i<n;i++){
        //     nums[i] = sc.nextInt(); 
        // }
        sc.close();

        System.out.println("Net Score is " + maxKelements(nums,k));
    }
}
