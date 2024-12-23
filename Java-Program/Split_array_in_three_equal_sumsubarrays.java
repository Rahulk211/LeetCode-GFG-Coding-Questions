import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Split_array_in_three_equal_sumsubarrays {

    private static List<Integer> findSplit(int[] arr){
        int totalsum =0;
        for(int ele : arr){
            totalsum += ele;
        }

        List<Integer> res = new ArrayList<>(Arrays.asList(-1,-1));
        if(totalsum %3 != 0){
            return res;
        }

        int target = totalsum/3;
        int currsum= 0;
        int f_idx = -1;
        int s_idx = -1;
        for(int i=0;i<arr.length;i++){
            currsum +=arr[i];
            if(currsum == target && f_idx == -1){
                f_idx = i;
            }
            else if(currsum == 2*target && f_idx !=-1){
                s_idx = i;
                res.set(0,f_idx);
                res.set(1, s_idx);
                return res;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,0,4};
        findSplit(arr);
    }
}
