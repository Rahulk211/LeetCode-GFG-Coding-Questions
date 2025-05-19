import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII {

    private static List<String> longestSubsequence(String[] words, int[] groups){
        int n = words.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int lsb = 1;
        int lsbIdx = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j])){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j]+1;
                        parent[i] = j;
        
                        if(lsb<dp[i]){
                            lsb = dp[i];
                            lsbIdx = i;
                        }
                    }
                }
            }

        }

        List<String> res = new ArrayList<>();
        while(lsbIdx !=-1){
            res.add(words[lsbIdx]);
            lsbIdx = parent[lsbIdx];
        }
        Collections.reverse(res);
        return res;
    }

    private static boolean hammingDistance(String s1, String s2){
        int dis=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                dis++;
            }
        }

        if(dis == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String[] words = {"bab","dab","cab"};
        int[] groups = {1,2,2};
        System.out.println(longestSubsequence(words, groups));
    }
}
