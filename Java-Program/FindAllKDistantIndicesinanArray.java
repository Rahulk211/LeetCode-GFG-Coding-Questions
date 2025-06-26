import java.util.List;
import java.util.Scanner;

public class FindAllKDistantIndicesinanArray {

    private static List<Integer> findKDistantIndices(int[] nums, int key, int k){
        int n = nums.length;
        int i=0;
        List<Integer> result = new java.util.ArrayList<>();
        while (i < n) {
            if (nums[i] == key) {
                for(int m = Math.max(0, i - k); m <= Math.min(n - 1, i + k); m++) {
                    if (!result.contains(m)) {
                        result.add(m);
                    }
                }
            }
            i++;
        } 
       
        java.util.Collections.sort(result);

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        System.out.println(findKDistantIndices(nums, key, k));
    }
}
