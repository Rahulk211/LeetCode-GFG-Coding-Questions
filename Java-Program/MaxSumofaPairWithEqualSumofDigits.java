import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSumofaPairWithEqualSumofDigits {

    private static int findSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int maximumSum(int[] nums){
        // int n = nums.length;
        int maxsum =-1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            int sum =findSum(num);
            if(map.containsKey(sum)){
                maxsum = Math.max(maxsum, num + map.get(sum));
                map.put(sum,Math.max(map.get(sum),num));
            }
            else{
                map.put(sum, num);
            }
        }
        return maxsum;

    }
    public static void main(String[] args) {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSum(nums));
    }
}
