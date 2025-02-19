import java.util.HashMap;
import java.util.Map;

public class TuplewithSameProduct {

    private static int tupleSameProduct(int[] nums){
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int prd = nums[i]*nums[j];
                count += (map.getOrDefault(prd, 0)*8);
                map.merge(prd, 1, Integer::sum);
            }
        }
        return count;
        // int res=0;
        // for(int val : map.values()){
        //     if(val == 2){
        //         res+=8;
        //     }
        //     if(val>2){
        //         res += 8*((val*(val-1))/2);
        //     }
        // }
        // return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,4,5};
        System.out.println(tupleSameProduct(nums));
    }
}
