import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingPairsWithaCertainSum {

    static int[] nums1,nums2;
    static Map<Integer, Integer> map;

    public FindingPairsWithaCertainSum(int[] nums1, int[] nums2) {
        FindingPairsWithaCertainSum.nums1 = nums1;
        FindingPairsWithaCertainSum.nums2 = nums2;
        map = new HashMap<>();
        for(int num:nums2){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
    }

    public static void add(int idx, int val) {
        map.put(nums2[idx], map.get(nums2[idx])-1);
        if(map.get(nums2[idx])==0){
            map.remove(nums2[idx]);
        }
        map.put(nums2[idx]+val, map.getOrDefault(nums2[idx]+val, 0)+1);

        nums2[idx]+=val; 
    }

    public static int count(int tot) {
        int cnt = 0;
        for (int num : nums1) {
            int tg = tot - num;
            cnt+=map.getOrDefault(tg, 0);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n1");
        int n1 = sc.nextInt();
        System.out.println("Enter n2");
        int n2 = sc.nextInt();

        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];

        System.out.println("Enter nums1");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter nums2");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        sc.close();

        @SuppressWarnings("unused")
        FindingPairsWithaCertainSum fsp = new FindingPairsWithaCertainSum(nums1, nums2);
        System.out.print(count(7) + " ");
        add(3, 2);
        System.out.print(count(8) + " ");
        System.out.print(count(4) + " ");
        add(0, 1);
        add(1, 1);
        System.out.print(count(7));
    }
}
