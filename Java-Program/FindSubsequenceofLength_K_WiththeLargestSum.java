import java.util.Arrays;

public class FindSubsequenceofLength_K_WiththeLargestSum {

    private static int[] maxSubsequence(int[] nums, int k){
        int n = nums.length;
        if(k>n){
            return new int[0];
        }
        int[][] vals = new int[n][2];
        for(int i=0;i<n;i++){
            vals[i][0] = i;
            vals[i][1] = nums[i];
        }
        
        Arrays.sort(vals, (a,b) -> Integer.compare(b[1], a[1]));

        Arrays.sort(vals, 0, k, (a,b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = vals[i][1];
        }
        return res;

        
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 3};
        int k = 2;
        
        int[] res = maxSubsequence(arr, k);
        for(int i : res){
            System.out.print(i+" ");
        }
    }
}
