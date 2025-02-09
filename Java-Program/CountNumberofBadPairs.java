import java.util.HashMap;
import java.util.Map;

public class CountNumberofBadPairs{

    private static long countBadPairs(int[] nums){
        long cnt=0;
        int n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey((nums[i]-i))){
                cnt+=map.get(nums[i]-i);
            }
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i, 0)+1);
        }
        
        return ((n*(n-1))/2) - cnt;
    }
public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    System.out.println(countBadPairs(nums));
}
}