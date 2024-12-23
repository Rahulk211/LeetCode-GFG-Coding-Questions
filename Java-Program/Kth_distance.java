//Given an unsorted array arr and a number k which is smaller than the size of the array. 
//Return true if the array contains any duplicate within k distance throughout the array else false.

import java.util.HashSet;

public class Kth_distance {

    private static boolean checkDuplicatesWithinK(int[] arr, int k){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            // If set already contains the element, we found a duplicate within k distance
            if (set.contains(arr[i])) {
                return true;
            }

            // Add the current element to the set
            set.add(arr[i]);

            // Maintain the set size to k, remove the element that is k distance away
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        // If no duplicates were found within k distance
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5};
        int k = 3;
        System.out.println(checkDuplicatesWithinK(nums, k));
    }
    
}
