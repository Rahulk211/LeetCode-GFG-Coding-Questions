import java.util.Scanner;

public class LongestBinarySubsequenceLessThanorEqualtoK {

    private static int longestSubsequence(String s, int k){
        int n = s.length();
        int zeros =0;
        int ones = 0;
        int value =0;
        int pow =1;

        for(char c : s.toCharArray()){
            if(c=='0') zeros++;
        }

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                if(value + pow > k) {
                    continue;
                }

                value += pow;
                ones++;
            }

            pow <<= 1;
            if(pow > k) {
                break;
            }
        }

        return zeros + ones;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k=sc.nextInt();
        sc.close();

        System.out.println(longestSubsequence(s, k));

        
    }
}
