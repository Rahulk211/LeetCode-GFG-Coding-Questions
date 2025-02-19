import java.util.Arrays;
import java.util.Scanner;

public class MinimumNumberofRemovalstoMakeMountainArray {
    static int minimumMountainRemovals(int[] nums){

        if(nums.length<3){
            return 0;
        }

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j]){
                    lds[i] = Math.max(lds[i],lds[j]+1);
                }
            }
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(lis[i]>1 && lds[i] >1){
                res = Math.max(lis[i]+lds[i]-1, res);
            }
        }

        return n-res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements of array : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(minimumMountainRemovals(nums));
        //minimumMountainRemovals(nums);
    }
    
}
