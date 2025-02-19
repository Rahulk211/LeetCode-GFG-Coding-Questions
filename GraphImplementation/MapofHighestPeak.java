import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MapofHighestPeak{

    static class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    private int[][] highestPeak(int[][] iswater){
        int m = iswater.length;
        int n = iswater[0].length;
        boolean[][] vis = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();
        int[][] heights = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(iswater[i][j] == 1){
                    q.add(new Pair(i,j));
                    vis[i][j] = true;
                    heights[i][j] = 0;
                }
            }
        }

        int[] dirx = {1,0,-1,0};
        int[] diry = {0,1,0,-1};
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                int x = p.x;
                int y = p.y;
                for(int j=0;j<4;j++){
                    int nx = x+dirx[j];
                    int ny = y+diry[j];
                    if(nx>=0 && nx< m && ny>=0 && ny<n && !vis[nx][ny] && iswater[nx][ny]!=1){
                        q.add(new Pair(nx,ny));
                        vis[nx][ny] = true;
                        heights[nx][ny]=level+1;
                    }
                }
            }
            level+=1;
        }

        return heights;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] isWater = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                isWater[i][j] = sc.nextInt();
            }
        }
        sc.close();

        MapofHighestPeak obj = new MapofHighestPeak();
        int[][] result =obj. highestPeak(isWater);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print( result[i][j]+" ");
            }
            System.out.println();
        }
    }

}