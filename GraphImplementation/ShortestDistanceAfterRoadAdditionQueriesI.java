import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestDistanceAfterRoadAdditionQueriesI {

    private static int[] shortestDistanceAfterQueries(int n, int[][] queries){
        int[] res = new int[queries.length];
        // int[][] matrix = new int[n][n];
        // for(int i=0;i<n;i++){
        //     if(i+1<n){
        //         matrix[i][i+1] = 1;
        //     }
        // }

        // for(int[] query : queries){
        //     matrix[query[0]][query[1]] = 1;
        // }
        List<List<Integer>> nodes = new ArrayList<>();
        for(int i=0;i<n;i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(i+1<n){
                nodes.get(i).add(i+1);
            }
        }
        System.out.println(nodes);

        for(int i=0;i<queries.length;i++){
            nodes.get(queries[i][0]).add(queries[i][1]);
            System.out.println(nodes);
            res[i] = bfs(nodes);
        }

        return res;
    }

    private static int bfs(List<List<Integer>> nodes){
        boolean[] visited = new boolean[nodes.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
        
            for(int i=0;i<size;i++){
                int node = queue.poll();
                if(node == nodes.size()-1){
                    return level;
                }
                //visited[node] = true;
                for(Integer n : nodes.get(node)){
                    if(visited[n] == false){
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
            level++;
        }

        return level;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        int n = sc.nextInt();
        System.out.println("Enter length of queries array : ");
        int m = sc.nextInt();
        System.out.println("Enter element of queries : ");
        int[][] queries = new int[m][2];
        for (int i = 0; i < m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sc.close();

        int[] ans = shortestDistanceAfterQueries(n, queries);
        for(int num: ans){
            System.out.print(num+" ");
        }
    }
}
