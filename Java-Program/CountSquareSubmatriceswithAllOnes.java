import java.util.Scanner;

public class CountSquareSubmatriceswithAllOnes{

    private static int countSquares(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int i=0;i<m;i++) {
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1] , dp[i][j-1]));
                }
            }
        }

        int sum =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum += dp[i][j];
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter numbers of rows : ");
        int n = sc.nextInt();
        System.out.print("\nEnter numbers of rows : ");
        int m = sc.nextInt();
        int[][] matrix = new int[n][m]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        sc.close();

        System.out.println(countSquares(matrix));
    }
}