import java.util.HashMap;
import java.util.Map;

public class CounttheNumberofGoodSubarrays {

    private static int countGood(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (map.containsKey(nums[j])) {
                pair += map.get(nums[j]);
                map.put(nums[j], map.get(nums[j]) + 1);
            } else {
                map.put(nums[j], 1);
            }

            while (pair >= k) {
                count += n - j;
                map.put(nums[i], map.get(nums[i]) - 1);
                pair -= map.get(nums[i]);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 3, 2, 2, 7, 11, 13, 4 };
        int k = 2;

        System.out.println(countGood(nums, k));
    }
}