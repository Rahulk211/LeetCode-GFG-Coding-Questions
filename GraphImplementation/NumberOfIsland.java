import java.util.Scanner;

public class NumberOfIsland {

    public static void BFS(int row,int col,int[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] ==0){
            return;
        }
        grid[row][col] = 0;
        BFS(row+1,col,grid);
        BFS(row-1,col,grid);
        BFS(row,col+1,grid);
        BFS(row,col-1,grid);
    }

    public static int noIsland(int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int cnt=0;

        for(int row = 0;row<n;row++){
            for(int col =0 ; col<m;col++){
                if(grid[row][col] == 1){
                    cnt++;
                    BFS(row,col,grid);
                }
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] grid = new int[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("Number of island : " + noIsland(grid)); 

    }
}
