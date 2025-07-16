import java.util.Scanner;

public class FindtheMaximumLengthofValidSubsequenceI {

    private static int maximumLength(int[] nums){
        int n = nums.length;
        int odd_cnt = (nums[0]%2==0 ? 0:1);
        int even_cnt =(nums[0]%2==0 ? 1:0);
        int alternate = 1;
        boolean exp_even = (nums[0]%2==0 ? false:true);

        for(int i=0;i<n;i++){
            if(nums[i] % 2 == 0){
                even_cnt++;
                if(exp_even){
                    alternate++;
                    exp_even = false;
                }
            }
            else{
                odd_cnt++;
                if(!exp_even){
                    alternate++;
                    exp_even = true;
                }
            }
        }

        return Math.max(Math.max(odd_cnt, even_cnt), alternate);


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println( maximumLength(nums));
    }
}
