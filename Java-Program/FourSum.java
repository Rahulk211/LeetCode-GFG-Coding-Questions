//import java.util.Arrays;
//import java.util.HashSet;
import java.util.Scanner;

public class FourSum {

    public static void fourSum(int[] nums, int target) {
        int sum =0, n = nums.length;
        int [] arr = new int[4];
        for(int i=0;i<n-3;i++){
            sum=nums[i]+nums[i+1]+nums[i+2]+nums[i+3];
            if(sum==target){
                for(int j=0;j<4;j++){
                    arr[j]=nums[i];
                    i++;
                }
            }
        }
        for(int i=0;i<4;i++){
            System.out.print(arr[i]+" ");
        }
        //HashSet<Integer> set = new HashSet<>();
        //Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(set.contains(target-nums[i])==true){
        //         return true;
        //     }
        //     set.add(nums[i]);
        // }
        // return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int size = sc.nextInt();
        int[] nums = new int[size];
        System.out.println("enter the elements of array");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println("enter the target");
        int k = sc.nextInt();

        fourSum(nums, k);

        sc.close();
    }
}
