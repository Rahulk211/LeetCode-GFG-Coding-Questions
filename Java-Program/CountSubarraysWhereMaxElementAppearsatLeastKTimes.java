public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    private static long findMax(int[] nums){
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        return max;
    }
    private static long countSubarrays(int[] nums, int k){
        long maxele = findMax(nums);
        int freq = 0;

        for(int num : nums){
            if(num == maxele){
                freq++;
            }
        }
        if(freq <k){
            return 0;
        }

        int i = 0, j = 0;
        int n = nums.length;
        long cnt = 0;
        int freq1 = 0;
        while(j<nums.length){
            if(nums[j]==maxele){
                freq1++;
            }
            while(freq1>=k){
                cnt+=n-j;
                if(nums[i]==maxele){
                    freq1--;
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {1,4,2,1};
        int k = 3;

        System.out.println(countSubarrays(nums, k));
    }
}
