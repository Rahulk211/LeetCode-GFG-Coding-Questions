import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
    static class Pair{
        int row;
        int col;
        int time;

        Pair(int r,int c,int t){
            row = r;
            col = c;
            time = t;
        }
    }

    private static int orangesRotting(int[][] grid){
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int tm = 0;
        int[] r = {-1,0,1,0};
        int[] c = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;
                int time = p.time;
                tm = Math.max(tm,time);
                for(int j=0;j<4;j++){
                    int nr = row + r[j];
                    int nc = col + c[j];
                    if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length 
                        && grid[nr][nc] == 1 && visited[nr][nc]== 0){
                        visited[nr][nc] = 2;
                        q.add(new Pair(nr,nc,time+1));
                        fresh--;
                    }
                }
            }
        }
        if(fresh == 0) return tm;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n =sc.nextInt();

        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println("time taken : "+ orangesRotting(grid));
    }
}
