
import java.util.Scanner;


public class CheckIfArrayPairsAreDivisiblebyk {

    private static boolean canArrange(int[] nums, int k){
        int[] set = new int[k];

        for(int num : nums){
            int rem = num%k;
            if(rem<0){
                rem = rem+k;
            }
            set[rem]++;
        }

        if(set[0]%2!=0) return false;
        for(int i = 1;i<=k/2;i++){
            if(set[i] != set[k-i] ){
                return false;
            }
        }
        

        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();                   //[1,2,3,4,5,6], k = 7
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        sc.close();
        System.out.println(canArrange(nums,k));
    }
}
