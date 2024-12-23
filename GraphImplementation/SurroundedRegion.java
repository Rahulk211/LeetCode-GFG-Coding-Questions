import java.util.Scanner;

public class SurroundedRegion {

    private static void dfs(int[][] mat, boolean[][] vis,int row,int col,int n,int m){
        vis[row][col] = true;
    
        if(row-1>=0 && col<m && vis[row-1][col]==false && mat[row-1][col]==0){
            dfs(mat, vis, row-1, col, n, m);
        }
        if(row+1<n && col<m && vis[row+1][col]==false && mat[row+1][col]==0){
            dfs(mat, vis, row+1, col, n, m);
        }
        if(row<n && col-1>=0 && vis[row][col-1]==false && mat[row][col-1]==0){
            dfs(mat, vis, row, col-1, n, m);
        }
        if(row<n && col+1<m && vis[row][col+1]==false && mat[row][col+1]==0){
            dfs(mat, vis, row, col+1, n, m);
        }
    }

    private static int[][] surroundedRegion(int[][] mat, int n,int m){
        if(mat == null || n == 0 || m == 0) return mat;
        boolean[][] vis = new boolean[n][m];
        //traverse the top and bottom border.
        for(int i =0;i<m;i++){
            if(vis[0][i] == false && mat[0][i]==0){
                dfs(mat,vis,0,i,n,m);
            }
            if(vis[n-1][i] == false && mat[n-1][i] == 0){
                dfs(mat,vis,n-1,i,n,m);
            }
        }

        // traverse left and right columns
        for(int i=0;i<n;i++){
            if(vis[i][0] == false && mat[i][0] == 0){
                dfs(mat,vis,i,0,n,m);
            }
            if(vis[i][m-1] == false && mat[i][m-1]==0){
                dfs(mat,vis,i,m-1,n,m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == false && mat[i][j] == 0){
                    mat[i][j] = 1;
                }
            }
        }

        return mat;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] res = surroundedRegion(mat,n,m);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
