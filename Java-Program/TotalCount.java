public class TotalCount {

    private static int totalCount(int[] nums, int k){
        // int max_count = 0;
        // for(int n : nums){
        //     int cnt = 0;
        //     while(n>0){
        //         if(n<=k){
        //             cnt++;
        //             n = n-n;
        //         }
        //         if(n>k){
        //             n=n-k;
        //             cnt++;
        //         }
                
        //     }
        //     max_count += cnt; 
        // }

        // return max_count;
        int sum = 0;
        for (int n : nums){
            sum += n/k + (n%k != 0 ? 1 : 0);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {5, 8, 10, 13};
        int k = 3;
        System.out.println(totalCount(nums,k));
    }
}
