public class NumberOfSubArraysWithOddSum {

    private static int numberOfSubArrays(int[] nums){
        int count = 0;
        int prefixsum =0;
        int even=1;
        int odd = 0;

        for(int num : nums){
            prefixsum += num;
            if(prefixsum%2 !=0){
                count = (count+even)%1000000007;
                odd++;
            }
            else{
                count = (count+odd)%1000000007;
                even++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(numberOfSubArrays(nums));
    }
}
