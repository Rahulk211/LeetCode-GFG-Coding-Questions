import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BitwiseORsofSubarrays {
    private static int subarrayBitwiseORs(int[] nums) {
        //int n = nums.length;
        Set<Integer> st = new HashSet<>();
        Set<Integer> st_p = new HashSet<>();
        Set<Integer> st_n = new HashSet<>();
        for(int num:nums){
            st_n.clear();
            st_n.add(num);
            for(int x:st_p){
                st_n.add(x | num);
            }
            st_p.clear();
            st_p.addAll(st_n);
            st.addAll(st_p);
        }
        
        return st.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(subarrayBitwiseORs(nums));
    }
}
