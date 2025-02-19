//Graph implementation using adjancy matrix.
import java.util.Scanner;

public class AdjMatrixImplementation {

    public static int[][] adjMatrix(int n,Scanner sc){
        int[][] adj = new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            int r=sc.nextInt();
            int c = sc.nextInt();

            adj[r][c]=1;
            adj[c][r]=1;
        }

        return adj;
    }

    public static void printGraph(int[][] adj){
        for(int i=1;i<adj.length;i++){
            for(int j=1;j<adj.length;j++){
                System.out.print(adj[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n=sc.nextInt();

        int[][] adj = adjMatrix(n,sc);
        printGraph(adj);
        sc.close();
    }
}