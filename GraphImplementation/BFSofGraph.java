import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSofGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void buildAdjList(Scanner sc, int n){
        for(int i = 0 ; i <= n; i++ ){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<=n;i++){
            System.out.print("enter u: ");
            int  u = sc.nextInt();
            
            System.out.print("enter v: ");
            int v = sc.nextInt();

            System.out.println();
            graph.get(u).add(v);
            //graph.get(v).add(u);
        }
    }

    public static void printAdjList(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+"->");
            for(int j=0;j<graph.get(i).size();j++){
                System.out.print(graph.get(i).get(j)+" ");
            }
            System.out.println();
        }
    } 

    public static ArrayList<Integer> BFS(int start){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[graph.size()+1];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfs.add(node);

            for(Integer n : graph.get(node)){
                if(visited[n] == false){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

        return bfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n =sc.nextInt();
        buildAdjList(sc, n);
        System.out.println("Adjacency List");
        printAdjList();
        System.out.println("Enter the starting vertex");
        int start = sc.nextInt();
        sc.close();
        ArrayList<Integer> bfs = BFS(start);
        System.out.println("BFS Traversal: "+bfs);

    }
}
