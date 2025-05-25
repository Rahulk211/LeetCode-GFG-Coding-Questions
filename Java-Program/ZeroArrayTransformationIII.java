import java.util.Arrays;
import java.util.PriorityQueue;

public class ZeroArrayTransformationIII {

    private static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int sz = queries.length;
        int[] diff = new int[n + 1];
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int sum =0;
        int j=0;

        for(int i=0;i<n;i++){
            sum += diff[i];

            while (j<sz && queries[j][0]==i) {
                pq.offer(queries[j][1]);
                j++;
            }

            while (sum < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sum += 1;
                diff[pq.poll() +1] -=1;
            }

            if(sum < nums[i]){
                return -1;
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2 };
        int[][] queries = { { 0, 2 }, { 0, 2 }, { 1, 1 } };

        System.out.println(maxRemoval(nums, queries));
    }
}
