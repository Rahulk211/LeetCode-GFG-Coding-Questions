import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;


public class Pairs_with_difference_k {

    static int countPairsWithDiffK(int[] nums, int k){
        // Set<Integer> set = new HashSet<>();
        // for(int num : nums){
        //     set.add(num);
        // }

        // int cnt = 0;
        // for(int num : nums){
        //     if(set.contains(num+k)){
        //         cnt++;
        //     }
        // }

        // return cnt;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        } 
        int cnt = 0;
        for(int num : nums){
            if(map.containsKey(num-k)){
                cnt += map.get(num-k);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of array : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k : ");
        int k = sc.nextInt();
        sc.close();

        System.out.println(countPairsWithDiffK(nums,k));
    }
    
}
