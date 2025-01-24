import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStates {

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        int[] outdegree = new int[n];
        for(int i=0;i<n;i++){
            outdegree[i] = graph[i].length;
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for(int i=0;i<adj.get(node).size();i++){
                int neighbor = adj.get(node).get(i);
                outdegree[neighbor]--;
                if(outdegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] grid = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        List<Integer> ans = eventualSafeNodes(grid);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
