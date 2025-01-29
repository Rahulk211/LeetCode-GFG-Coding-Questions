import java.util.Arrays;
import java.util.Scanner;

public class RedundantConnection {

    static int find(int[] dsuf, int v){
        if(dsuf[v] == -1) return v;
        else return dsuf[v] = find(dsuf, dsuf[v]);
    }

    private static int[] findRedundantConnection(int[][] edges){
        int[] dsuf = new int[edges.length+1];
        Arrays.fill(dsuf, -1);
        for(int[] edge :edges){
            int parentx = find(dsuf,edge[0]);
            int parenty = find(dsuf,edge[1]);
            if(parentx == parenty){
                return edge;
            }
            else{
                dsuf[parentx] = parenty;
            }
        }
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n][2];
        for(int i =0;i<n;i++){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        sc.close();
        int[] res = findRedundantConnection(edges);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]+" ");
        }
    }
}
