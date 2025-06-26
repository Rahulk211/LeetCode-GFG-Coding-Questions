import java.util.Scanner;

public class SumofkMirrorNumbers {

    private static boolean isPalindrome(int num, int base){
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        String str = sb.toString();
        return str.equals(sb.reverse().toString());
    }

    private static long kMirror(int k, int n) {
        long sum =0;
        int cnt = 0;
        for (int i = 1; cnt < n; i++) {
            if (isPalindrome(i, k) && isPalindrome(i, 10)) {
                sum += i;
                cnt++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  k = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        System.out.println(kMirror(k, n));
    }
}
