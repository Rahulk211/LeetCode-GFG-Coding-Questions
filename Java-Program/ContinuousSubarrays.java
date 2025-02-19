public class ContinuousSubarrays {

    private static long continuousSubarrays(int[] nums){
        long count = 0;
        int n = nums.length;
        int range_max = Integer.MIN_VALUE;
        int range_min = Integer.MAX_VALUE;
        int win_len=0;
        int r=0,l=0;
        while(r<n){
            range_max = Math.max(range_max,nums[r]);
            range_min = Math.min(range_min,nums[r]);

            if(range_max-range_min > 2){
                win_len = r-l;
                count += (win_len*(win_len+1))/2;

                l=r;
                range_max = nums[r];
                range_min = nums[r];

                while(Math.abs(nums[r]-nums[l-1])<=2){
                    l--;
                    range_max = Math.max(range_max,nums[l]);
                    range_min = Math.min(range_min,nums[l]);
                }
                
                if(l<r){
                    win_len = r-l;
                    count = count - (win_len*(win_len+1))/2;
                }
            }
            r++;
        }

        win_len = r-l;
        count += (win_len*(win_len+1))/2;

        return count;
        
    }
    public static void main(String[] args) {
        int[] nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
    }
}
