// import java.util.ArrayList;
// import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Find_All_Triplets_with_Zero_Sum {

    private static List<List<Integer>> findTriplets(int[] arr){
        //List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                if(!map.containsKey(sum)){
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add( new int[] {i, j});
            }
        }

        Set<List<Integer>> res = new HashSet<>();
        for(int k=0;k<n;k++){
            int rem = -arr[k];
            if(map.containsKey(rem)){
                List<int[]> pair = map.get(rem);
                for(int[] p : pair){
                    if(p[0] != k && p[1] != k){
                        List<Integer> curr = Arrays.asList(k,p[0],p[1]);
                        Collections.sort(curr);
                        res.add(curr);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        int[] arr = {0, -1, 2,-3, 1};

        System.out.print(findTriplets(arr));
    }
}
