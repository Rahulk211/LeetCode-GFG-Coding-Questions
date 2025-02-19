public class CountServersthatCommunicate{

    private static int countServers(int[][] grid){
        int cnt = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && (row[i] > 1 || col[j] >1)){

                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
    }
}