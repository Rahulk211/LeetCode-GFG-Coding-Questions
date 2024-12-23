import java.util.HashMap;
import java.util.Map;

public class MaxDistanceBeetweenSameElements {

    private static int maxDistance(int[] nums){
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                max = Math.max(max,i-map.get(nums[i]));
            }
            else{
                map.put(nums[i],i);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,1,2,1};
        System.out.println(maxDistance(nums));
    }
}
