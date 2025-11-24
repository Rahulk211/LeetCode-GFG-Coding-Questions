import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLength_3PalindromicSubsequences{

    private static int countPalindromicSubsequence(String s){
        int n = s.length();
        int[] fst = new int[26];
        int[] lst = new int[26];
        Arrays.fill(fst, -1);
        Arrays.fill(lst, -1);

        for(int i = 0;i<n;i++){
            int val= s.charAt(i)-'a';
            if(fst[val] == -1){
                fst[val] = i;
            }
            lst[val] = i;
        }

        int cnt = 0;

        for(int i=0;i<26;i++){
            Set<Character> set = new HashSet<>();
            for(int j = fst[i]+1;j<lst[i];j++){
                set.add(s.charAt(j));
            }

            cnt += set.size();
        }

        return cnt;
    }
    public static void main(String[] args) {
        String s = "bbcbaba";

        System.out.println(countPalindromicSubsequence(s));
    }
}