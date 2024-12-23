import java.util.ArrayList;
import java.util.Scanner;

public class DFSOfaGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void buildAdjList(Scanner sc, int n){
        for(int i = 0 ; i <= n; i++ ){
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<n;i++){
            System.out.print("enter u: ");
            int  u = sc.nextInt();
            
            System.out.print("enter v: ");
            int v = sc.nextInt();

            System.out.println();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }

    public static ArrayList<Integer> DFS(Scanner sc){
        boolean[] visited = new boolean[graph.size()+1];
        ArrayList<Integer> dfs_list = new ArrayList<>();

        System.out.println("Enter starting node : ");
        int start = sc.nextInt();

        DFS_Traversal(dfs_list,visited,start);

        return dfs_list;
    }

    public static void DFS_Traversal(ArrayList<Integer> dfs_list, boolean[] visited,int start) {
        visited[start] = true;
        dfs_list.add(start);

        for(Integer it : graph.get(start)){
            if(visited[it] == false){
                DFS_Traversal(dfs_list, visited, it);
            }
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
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("enter number of vertices: ");
        int n = sc.nextInt();
        buildAdjList(sc,n);
        System.out.println("Adjacency List");
        printAdjList();
       
        ArrayList<Integer> dfs = DFS(sc);
        System.out.println("DFS Traversal of list : " + dfs);

    }
}
