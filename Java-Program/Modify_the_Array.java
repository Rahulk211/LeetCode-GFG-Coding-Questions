import java.util.ArrayList;
import java.util.List;

public class Modify_the_Array {

    private static List<Integer> modifyAndRearrangeArr(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > 0 && nums[i] == nums[i + 1]) {
                nums[i]*=2;
                nums[i+1]=0;
            }
        }
        for(int num : nums){
            if(num >0){
                res.add(num);
            }
        }
        while(res.size()<n){
            res.add(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 0, 4, 0, 8 };
        
        System.out.println(modifyAndRearrangeArr(nums));
    }
}
