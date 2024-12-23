import java.util.HashMap;
import java.util.Map;

public class Subarray_range_with_given_sum {

    private static int subarrayWithGivenSum(int[] nums, int tar){
        
        Map<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(sum,1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            map.put(sum,map.getOrDefault(sum, 0)+1);
            if(map.containsKey(sum-tar)){
                ans += map.get(sum-tar);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 20, 3, 10, 5};
        int targ = 33;
        System.out.println(subarrayWithGivenSum(nums, targ));
    }
    
}
