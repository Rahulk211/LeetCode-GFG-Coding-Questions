public class CountUnguardedCellsintheGrid {

    private static void dirctional_dfs(int[][] matrix,int row,int col,char D){
        if(row<0 || row>=matrix.length || col<0 || col>=matrix[0].length || matrix[row][col]==1){
            return;
        }
        matrix[row][col]=2;
        if(D=='L')dirctional_dfs(matrix,row-1,col,D);
        if(D=='R')dirctional_dfs(matrix,row+1,col,D);
        if(D=='U')dirctional_dfs(matrix,row,col-1,D);
        if(D=='D')dirctional_dfs(matrix,row,col+1,D);
    }

    private static int countUnguarded(int m, int n, int[][] guards, int[][] walls){
        int[][] matrix = new int[m][n];
        for(int[] g : guards){
            matrix[g[0]][g[1]] = 1;
        }
        for(int[] w : walls){
            matrix[w[0]][w[1]] = 1;
        }
        for(int[] g : guards){
            int i=g[0], j = g[1];
            dirctional_dfs(matrix,i-1,j,'L');
            dirctional_dfs(matrix,i+1,j,'R');
            dirctional_dfs(matrix,i,j-1,'U');
            dirctional_dfs(matrix,i,j+1,'D');
        }

        int cnt = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    cnt+=1;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] grid = {{0,0},{1,1},{2,3}};
        int[][] wall = {{0,1},{2,2},{1,4}};
        int m = 4;
        int n = 6;

        System.out.println(countUnguarded(m,n,grid,wall));
    }
}
