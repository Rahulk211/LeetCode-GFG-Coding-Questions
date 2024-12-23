import java.util.Arrays;
import java.util.Scanner;

public class CounttheNumberofFairPairs {

    private static int countFairPairs(int[] nums ,int lower, int upper){
        int count = 0;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int lb = lowerBound(nums,i+1,n,lower-nums[i]);
            int ub = upperBound(nums,i+1,n,upper-nums[i]);
            count +=(ub-lb);
        }
        return count;
    }
    static int lowerBound(int[] nums, int start, int end, int srt_target){
        int low = start, high = end;
        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= srt_target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int[] nums, int start, int end, int srt_target){
        int low = start;
        int high = end;
        while(low<high){
            int mid = low + (high - low) / 2;
            if(nums[mid]<=srt_target){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter lower value : ");
        int lower = sc.nextInt();
        System.out.print("\n Enter upper value : ");
        int upper = sc.nextInt();
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] nums = new int[n]; 
        System.out.println("Enter the element of arrays ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(countFairPairs(nums, lower, upper));

    }
    
}
