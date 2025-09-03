import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trinagle {

    private static int minimumTotal(List<List<Integer>> tri){
        int n = tri.size();
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = tri.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> tri = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                row.add(sc.nextInt());
            }
            tri.add(row);
        }
        sc.close();
        System.out.println(minimumTotal(tri));
    }
}
