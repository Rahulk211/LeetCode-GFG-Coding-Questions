import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class LongestSquareStreakinanArray {

    private static int longestSquareStreak(int[] nums){
        int max =-1;
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i : nums){
            int root = (int) Math.sqrt(i);

            if(root * root == i && map.containsKey(root)){
                map.put(i,map.get(root)+1);
                max = Math.max(max,map.get(i));
            } 
            else{
                map.put(i,1);
            }
        }

        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7};
        int res = longestSquareStreak(arr);
        System.out.println(res);
    }
    
}
