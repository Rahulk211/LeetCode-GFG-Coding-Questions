import java.util.Scanner;

public class Split_the_Array {

    private static int countgroup(int[] nums){
        int mod = 1000000007;
        int n = nums.length;
        int xor=0;
        for(int i=0;i<n;i++){
            xor ^= nums[i]; 
        }
        
        if(xor!=0) return 0;
        else{
            long ans = 1; // Use long to avoid overflow
            for (int i = 0; i < n - 1; i++) {
                ans = (ans * 2) % mod; // Calculate power of 2
            }
            return (int)(ans - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(countgroup(nums));
    }
}
