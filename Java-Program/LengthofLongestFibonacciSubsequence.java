import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LengthofLongestFibonacciSubsequence {

    private static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)));
        
        int maxLength = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int fib_len = 2;

                while (set.contains(a + b)) {
                    int c = a + b;
                    a = b;
                    b = c;
                    fib_len++;
                }
                maxLength = Math.max(maxLength, fib_len);
            }
        }
        return maxLength >= 3 ? maxLength : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(lenLongestFibSubseq(arr));
    }
}
