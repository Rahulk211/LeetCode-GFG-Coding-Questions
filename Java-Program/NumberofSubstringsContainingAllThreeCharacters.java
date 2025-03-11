// Given a string s consisting only of characters a, b and c.

// Return the number of substrings containing at least one occurrence of all these characters a, b and c.
import java.util.Arrays;
import java.util.Scanner;

public class NumberofSubstringsContainingAllThreeCharacters {
    private static int numberOfSubstrings(String str) {
        int n = str.length();
        int count = 0;

        int[] freq = new int[3];
        Arrays.fill(freq, 0);
        int i = 0, j = 0;
        while (j < n) {
            freq[str.charAt(j) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += (n - j);

                freq[str.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();

        System.out.println(numberOfSubstrings(str));
    }
}
