// import java.util.LinkedList;
// import java.util.Queue;
import java.util.Scanner;
// import java.util.Stack;

public class MaximumNumberofFishinaGrid {
    // static class Pair{
    //     int x;
    //     int y;
    //     Pair(int x,int y){
    //         this.x = x;
    //         this.y = y;
    //     }
    // }
    private static int DFS(int[][] grid, boolean[][] vis,int x,int y){
        vis[x][y] = true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int f = grid[x][y];
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length
            && grid[nx][ny]>0 && !vis[nx][ny]){
                f +=  DFS(grid,vis,nx,ny);
            }
        }
        return f;
    }
    private static int findMaxFish(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        // Queue<Pair> q = new LinkedList<>();
        // boolean[][] vis = new boolean[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(grid[i][j]>0){
        //             q.offer(new Pair(i,j));
        //         }
        //     }
        // }
        // int[] dx = {1,0,-1,0};
        // int[] dy ={0,1,0,-1};
        
        // int maxfishes = 0;
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     for(int i =0;i<size;i++){
        //         Pair p = q.poll();
        //         int x = p.x;
        //         int y = p.y;
        //         int curr = grid[x][y];
        //         for(int j=0;j<4;j++){
        //             int nx = x+dx[j];
        //             int ny = y+dy[j];
        //             if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]>0
        //                 && !vis[nx][ny]){
        //                     vis[nx][ny] = true;
        //                     q.offer(new Pair(nx,ny));
        //                     curr += grid[nx][ny];
        //             }
        //         }
        //         maxfishes = Math.max(maxfishes, curr);
        //     }
        // }
        // return maxfishes;

        
        boolean[][] vis = new boolean[m][n];
        int maxfishes = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    maxfishes = Math.max(maxfishes, DFS(grid, vis, i, j));
                }
            }

        }

        return maxfishes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();   //[[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
            }
        }
        sc.close();
        System.out.println(findMaxFish(grid));
    }
    
}
