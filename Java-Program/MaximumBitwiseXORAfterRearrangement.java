import java.util.Scanner;

public class MaximumBitwiseXORAfterRearrangement {

    // private static String opt_t(int[] cnt, String s) {
    //     StringBuilder sb = new StringBuilder();
    //     for (char ch : s.toCharArray()) {
    //         if (ch - '0' == 0 && cnt[1] > 0) {
    //             sb.append('1');
    //             cnt[1]--;
    //         } else if (ch - '0' == 1 && cnt[0] > 0) {
    //             sb.append('0');
    //             cnt[0]--;
    //         }
    //     }

    //     while (cnt[0] > 0) {
    //         sb.append('0');
    //         cnt[0]--;
    //     }

    //     while (cnt[1] > 0) {
    //         sb.append('1');
    //         cnt[1]--;
    //     }

    //     return sb.toString();
    // }

    private static String maximumXor(String s, String t) {
        int[] cnt = new int[2];
        for (char c : t.toCharArray()) {    
            cnt[c-'0']++;
        }

        char[] res = new char[s.length()];
        int i=0;
        while(i<s.length()){
            int bit = s.charAt(i)-'0';
            int nt = 1-bit;
            if(cnt[nt]>0){
                res[i]='1';
                cnt[nt]--;
            }
            else{
                res[i]='0';
                cnt[bit]--;
            }
            i++;
        }

        return new String(res);

        // String new_t = opt_t(cnt, s);

        // int num1 = Integer.parseInt(s, 2);
        // int num2 = Integer.parseInt(new_t, 2);

        // int xor = num1 ^ num2;
        // return Integer.toBinaryString(xor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        sc.close();
        System.out.println(maximumXor(s, t));
    }
}
