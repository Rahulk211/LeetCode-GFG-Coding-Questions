import java.util.Scanner;

public class ShortestCommonSuperSequence{

    private static void findLCS(int[][] dp,String s1,String s2){
        int m = dp.length;
        int n = dp[0].length;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }

    private static String shortestCommonSupersequence(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        findLCS(dp,str1,str2);
        StringBuilder ans = new StringBuilder();
        int i=m,j=n;

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans.append(str1.charAt(i-1));
                i--;
            }
            else{
                ans.append(str2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
        }


        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();

        System.out.println(shortestCommonSupersequence(str1,str2));
    }
}