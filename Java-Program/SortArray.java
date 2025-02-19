import java.util.PriorityQueue;

public class SortArray {

    public static void sort(int[] nums){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.offer(num);
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = queue.poll();
        }
    }
    public static void main(String[] args) {
        int[] nums = {4,0,-1,-3,5,8,-1};
        sort(nums);
        for(int i=0; i<nums.length;i++ ){
            System.out.print(nums[i]+" ");
        }
    }
}
