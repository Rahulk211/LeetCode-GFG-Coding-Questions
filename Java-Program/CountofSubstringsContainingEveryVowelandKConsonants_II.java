import java.util.HashMap;
import java.util.Map;

public class CountofSubstringsContainingEveryVowelandKConsonants_II {
    private static long countOfSubstrings(String word, int k) {
        if (word.length() < 5 + k) {
            return 0;
        }
        int[] consulant = new int[word.length()];
        int n = word.length();
        int next = n;
        for (int i = n - 1; i >= 0; i--) {
            consulant[i] = next;
            if (word.charAt(i) != 'a' || word.charAt(i) != 'e' || word.charAt(i) != 'i' || word.charAt(i) != 'o'
                    || word.charAt(i) != 'u') {
                next = i;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        long cnt = 0;
        int constt = 0;
        int prev = -1;
        while (r < n) {
            if (prev != r) {
                if (word.charAt(r) == 'a' || word.charAt(r) == 'e' || word.charAt(r) == 'i' || word.charAt(r) == 'o'
                        || word.charAt(r) == 'u') {
                    map.put(word.charAt(r), map.getOrDefault(word.charAt(r), 0) + 1);
                } else {
                    constt++;
                }
                prev = r;
            }
            if (r >= (5 + k - 1)) {
                if (map.size() == 5 && constt == k) {
                    cnt += consulant[r] - r;
                }

                if ((map.size() == 5 && constt == k) || constt > k) {
                    if (word.charAt(l) == 'a' || word.charAt(l) == 'e' || word.charAt(l) == 'i'
                            || word.charAt(l) == 'o'|| word.charAt(l) == 'u') {
                        map.put(word.charAt(l), map.getOrDefault(word.charAt(l), 0) - 1);

                        if (map.get(word.charAt(l)) <= 0) {
                            map.remove(word.charAt(l));
                        }
                    } else {
                        constt--;
                    }
                    l++;
                } else
                    r++;
            } else
                r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String word = "cdaeeaepbkioueeaep";
        int k = 3;
        System.out.println(countOfSubstrings(word, k));
    }
}
