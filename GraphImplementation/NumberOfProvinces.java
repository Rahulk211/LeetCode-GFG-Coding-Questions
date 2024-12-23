import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfProvinces {

    public static void buildAdjList(Scanner sc ,ArrayList<ArrayList<Integer>> adj, int V ){
        for(int i = 0 ; i <= V ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < V;i++){
            System.out.print("Enter value of u : ");
            int u = sc.nextInt();
            System.out.print("Enter value of v : ");
            int v = sc.nextInt();

            if(u<=0 && v<=0){
                break;
            }

            System.out.println();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public static int numberOfProvinces(ArrayList<ArrayList<Integer>> adjlist,int V){
        boolean[] visited = new boolean[V+1];
        int count=0;

        for(int i = 1;i<adjlist.size();i++){
            if(visited[i] == false){
                count++;
                DFS(adjlist,visited,i);
            }
        }
        return count;
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adjlist, boolean[] visited, int start){
        visited[start] = true;

        for(Integer it : adjlist.get(start)){
            if(visited[start] == false){
                DFS(adjlist,visited,it);
            }
        }
    }

    public static void printAdjList(ArrayList<ArrayList<Integer>> adjlist){
        for(int i=0;i<adjlist.size();i++){
            System.out.print(i+"->");
            for(int j=0;j<adjlist.get(i).size();j++){
                System.out.print(adjlist.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
        System.out.print("Enter no. of vertices : ");
        int v = sc.nextInt();

        buildAdjList(sc,adjlist,v);
        System.out.println("Adjacency List");
        printAdjList(adjlist);

        sc.close();
        System.out.println("Number of provinces : " + numberOfProvinces(adjlist, v));

    }
}