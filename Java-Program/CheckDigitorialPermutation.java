import java.util.Scanner;

public class CheckDigitorialPermutation {

    private static void findFactorials(int[] factorials) {
        for (int i = 3; i < 10; i++) {
            factorials[i] = i * factorials[i - 1];
        }
    }

    private static boolean isDigitorialPermutation(int n) {
        int[] factorials = new int[10];
        factorials[0] = 1;
        factorials[1] = 1;
        factorials[2] = 2;
        findFactorials(factorials);

        int num = findDigitorial(n, factorials);

        if (isdigitorial(n, num))
            return true;

        return false;
    }

    private static boolean isdigitorial(int n, int num) {
        int[] count = new int[10];

        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }

        while (num > 0) {
            count[num % 10]--;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (count[i] != 0)
                return false;
        }

        return true;
    }

    private static int findDigitorial(int n, int[] factorials) {
        int num = 0;
        while (n > 0) {
            int i = n % 10;
            num += factorials[i];
            n /= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println(isDigitorialPermutation(n));
    }
}
