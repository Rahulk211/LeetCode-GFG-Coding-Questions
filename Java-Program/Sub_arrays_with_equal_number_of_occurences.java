// Given an array arr[] and two integers say, x and y, find the number of 
// sub-arrays in which the number of occurrences of x is equal to the number
// of occurrences of y.

import java.util.HashMap;
import java.util.Map;

public class Sub_arrays_with_equal_number_of_occurences {

    private static int sameOccurrence(int arr[], int x, int y) {
        Map<Integer, Integer> map = new HashMap<>();
        int cntx = 0;
        int cnty = 0;
        int ans = 0;
        map.put(0, 1);

        for (int ele : arr) {
            if (ele == x) {
                ++cntx;
            }
            if(ele == y){
                ++cnty;
            }

            int diff = cntx-cnty;
            if(map.containsKey(diff)){
                ans += map.get(diff);
            }
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int x = 3;
        int y = 5;

        System.out.println(sameOccurrence(arr, x, y));

    }
}
