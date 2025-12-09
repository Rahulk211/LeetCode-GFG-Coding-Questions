
import java.util.HashMap;
import java.util.Map;


public class CountSpecialTriplets {
    private static int specialTriplets(int[] nums){
        int n = nums.length;
        int mod = 1_000_000_007;
        Map<Integer, Integer> freqprev= new HashMap<>(), total= new HashMap<>();
        long res = 0;
        for (int num : nums) {
            total.put(num, total.getOrDefault(num, 0) + 1);
        }

        for(int j=0;j<n;j++){
            int before = freqprev.getOrDefault(nums[j]*2, 0);
            int after = total.getOrDefault(nums[j]*2, 0) - before;
            if(nums[j] == 0){
                after -= 1;
            }
            res = (res + ((long)before * after) % mod) % mod;
            // res += (before * after) % mod;
            freqprev.put(nums[j], freqprev.getOrDefault(nums[j], 0) + 1);
        }
        return (int)res;
       
    }
    public static void main(String[] args) {
        int[] nums = {8,4,2,8,4};
        System.out.println(specialTriplets(nums));
    }
}
