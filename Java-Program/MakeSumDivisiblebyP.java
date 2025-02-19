public class MakeSumDivisiblebyP {
    private static int minSubarray(int[] arr, int p){
        int n = arr.length;
        int sum=0;
        for(int num :arr){
            sum += num;
        }
        int target = sum % p;
        if(target==0){
            return 0;
        }
        int i =0;
        int j=0;
        int len_of_subarr=Integer.MAX_VALUE;;
        int sum2=0;
        while(j<n){
            sum2 = sum2+arr[j];
            if(arr[j]==target){
                return 1;
            }
            
            if (sum2>target) {
                sum2-=arr[i];
                i++;
            }
            if(sum2==target){
                len_of_subarr = Math.min(len_of_subarr,j-i+1);
                sum2=0;
            }
            j=j+1;
        }
        return len_of_subarr;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2};
        int p = 6;
        System.out.println(minSubarray(arr,p));
    }
}
