import java.util.Arrays;
import java.util.Scanner;

public class DefusetheBomb {

    private static int[] decrypt(int[] nums, int k){
        int[] result = new int[nums.length];
        int n = nums.length;
        
        if(k>0){
            for(int i=0;i<n;i++){
                int cnt =0;
                int j=i;
                int sum=0;
                while(cnt<k){
                    j = (j+1)%n;
                    sum += nums[j];
                    cnt++;                    
                }
                result[i] = sum;
            }
        }
        else if(k<0){
            for(int i=0;i<n;i++){
                int cnt =0;
                int j=i;
                int sum=0;
                while(cnt>k){
                    j = (j-1+n)%n;
                    sum += nums[j];
                    cnt--;                    
                }
                result[i] = sum;
            }
        }
        else{
            Arrays.fill(result, 0);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();

        int[] res = decrypt(nums, k);
        for(int num : res){
            System.out.print(num+" ");
        }
    }
    
}
