import java.util.Comparator;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations_I {

    private static int[] getFinalState(int[]nums, int k, int multi){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});
        }

        for(int i=0;i<k;i++){
            int[] top = pq.poll();
            int idx = top[1];
            int num = top[0];
            nums[idx] = num*multi;
            pq.add(new int[]{nums[top[1]],top[1]});
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k=5;
        int multi = 2;
        getFinalState(nums,k,multi);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    
}
