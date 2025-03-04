import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Word_Break {
    private static boolean wordBreak(List<String> str, String s){
        Set<String> set = new HashSet<>(str);
        int n = s.length();

        int maxlen = 0;
        for(String word : str){
            maxlen = Math.max(maxlen,word.length());
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxlen);j--){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> str = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            str.add(sc.next());
        }
        String s = sc.next();
        sc.close();
        System.out.println(wordBreak(str,s));
    }
    
}
