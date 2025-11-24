public class BinaryPrefixDivisibleBy5 {

    private static boolean[] prefixesDivBy5(int[] nums){
        int n = nums.length;
        boolean[] res = new boolean[n];
        int X = 0;
        for(int i =1;i<n;i++){
            X = ((2*X) + nums[i])%5;
            res[i] = X ==0 ? true : false;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        boolean[] res = prefixesDivBy5(nums);
        for(boolean bln : res){
            System.out.print(bln + " ");
        }
    }
}
