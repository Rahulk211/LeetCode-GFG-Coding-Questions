import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class MaximumNumberofPointsFromGridQueries{

    static class Pair{
        int a;
        int b;

        Pair(int a,int b){
            this.a = a;
            this.b = b;
        }
    }

    static class Triplet{
        int a;
        Pair b;
        Triplet(int a, Pair b){
            this.a = a;
            this.b = b;
        }
    }

    private static int[] maxPoints(int[][] grid, int[] queries){
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        Set<Integer> set = new TreeSet<>();
        for(int num : queries){
            set.add(num);
        }

        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->a.a-b.a);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;

        pq.offer(new Triplet(grid[0][0], new Pair(0,0)));
        visited[0][0]=true;

        int[] xdir = {1,0,-1,0};
        int[] ydir = {0,1,0,-1};

        for(int q : set){
            while(!pq.isEmpty()){
                Triplet t = pq.poll();
                int val = t.a;
                int x = t.b.a;
                int y = t.b.b;

                if(val >= q){
                    pq.offer(t);
                    break;
                }
                max++;

                for(int i=0;i<4;i++){
                    int nx = x+xdir[i];
                    int ny = y+ydir[i];
                    if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        pq.offer(new Triplet(grid[nx][ny], new Pair(nx,ny)));

                    }
                }
            }

            map.put(q,max);
        }

        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = map.get(queries[i]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};
        
        int[] res = maxPoints(grid, queries);

        for(int n : res){
            System.out.print(n+" ");
        }
    }
}