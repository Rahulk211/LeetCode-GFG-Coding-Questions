public class PathsinMatrixWhoseSumIsDivisiblebyK {

    private static int solve(int[][] grid,int sum, int i, int j, int k, int[][][] dp){
        int m = grid.length;
        int n = grid[0].length;

        if(i==m-1 && j==n-1){
            if((sum+grid[i][j]) %k== 0) return 1;
            else return 0;
        }

        if(i==m || j==n) return 0;

        if(dp[i][j][sum] != 0) return dp[i][j][sum];

        int right = solve(grid, (sum+grid[i][j])%k, i,j+1, k, dp);
        int down = solve(grid, (sum+grid[i][j])%k, i+1,j, k, dp); 

        dp[i][j][sum] = (right + down) % 1000000007;
        return dp[i][j][sum];
    } 

    private static int numberOfPaths(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];

        return solve(grid, 0, 0,0,k, dp);
    }
    public static void main(String[] args) {
        int[][] grid = {
            {5,2,4},
            {3,0,5},
            {0,7,2}
        };
        int k = 3;

        System.out.println(numberOfPaths(grid,k));
    }
}
