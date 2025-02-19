/*
 * Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit
 *  if you are currently in this cell. The sign of grid[i][j] can be:

1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
Notice that there could be some signs on the cells of the grid that point outside the grid.

You will initially start at the upper left cell (0, 0). A valid path in the grid is a
path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1)
following the signs on the grid. The valid path does not have to be the shortest.

You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

Return the minimum cost to make the grid have at least one valid path.

*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCosttoMakeatLeastOneValidPathinaGrid {
    static class Pair{
        int cost;
        int x;
        int y;
        
        
        Pair(int cost, int x, int y){
            this.cost = cost;
            this.x = x;
            this.y = y;
        }
    }

    public static boolean isValid(int x,int y, int m, int n){
        return(x>=0 && x<m && y>=0 && y<n);
    }

    public static int formGraph(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.cost - b.cost;
            }
        });
        boolean[][] vis = new boolean[m][n];

        pq.offer(new Pair(0,0,0));
        //vis[0][0] = true;
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int cost = p.cost;
            int x = p.x;   //[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
            int y = p.y;
            if(vis[x][y]) continue;
            if(x==m-1 && y==n-1){
                return cost;
            }
            vis[x][y] = true;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(isValid(nx,ny,m,n) && !vis[nx][ny]){
                    int ncost = cost;
                    ncost += (i+1) == grid[x][y]?0:1;
                    pq.offer(new Pair(ncost,nx,ny));
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("Net cost: "+formGraph(grid));
    }
}
