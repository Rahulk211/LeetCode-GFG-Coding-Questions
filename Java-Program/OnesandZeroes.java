public class OnesandZeroes {

    private static int findMaxForm(String[] strs, int m,int n){
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int z=0, o=0;
            for(char c :str.toCharArray()){
                if(c=='0') z++;
                else o++;
            }

            for(int i=m;i>=z;i--){
                for(int j=n;j>=o;j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - z][j - o] + 1);
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;

        System.out.println(findMaxForm(strs, m, n));
    }
}
