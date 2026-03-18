public class CountSubmatriceswithTopLeftElementandSumLessThan_k{

    private static int countSubmatrices(int[][] grid, int k){
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0, j=1; j<n; j++){
            grid[i][j] += grid[i][j-1];
        }

        for(int i=1, j=0; i<m; i++){
           grid[i][j] += grid[i-1][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                grid[i][j] += grid[i][j-1] + grid[i-1][j] - grid[i-1][j-1];
            }
        }

        int res = 0;
        for(int[] row : grid){
            res += findSubmatrics(row, k, n);
        }

        return res;
    }

    private static int findSubmatrics(int[] row, int k, int n){
        for(int i=n-1;i>=0;i--){
            if(row[i] <= k){
                return i+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] grid = {{7, 6, 3}, {6, 6, 1}};
        int k = 20;

        System.out.println(countSubmatrices(grid, k));
    }
}