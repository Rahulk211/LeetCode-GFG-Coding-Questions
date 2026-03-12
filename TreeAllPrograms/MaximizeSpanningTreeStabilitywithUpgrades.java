import java.util.ArrayList;
import java.util.List;

public class MaximizeSpanningTreeStabilitywithUpgrades {
    static class DSU {
        int[] parent;
        int[] rank;

        public DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }

            parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int x_parent = find(x);
            int y_parent = find(y);

            if (x_parent == y_parent) {
                return false;
            }

            if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }

            return true;
        }
    }

    private static int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            // int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }
        int low = 1, high = (int) (2 * 1e5);
        int res = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(n, edges, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }

    private static boolean check(int n, int[][] edges, int k, int mid){
        DSU dsu = new DSU(n);

        List<int[]> upgrade = new ArrayList<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if(m==1){
                if(s<mid)   return false;

                dsu.union(u,v);
            }else{
                if(s>=mid){
                    dsu.union(u, v);
                }else if(s*2 >= mid){
                    upgrade.add(new int[] {u, v});
                }
            }
        }

        for(int[] edge : upgrade){
            int u = edge[0];
            int v = edge[1];

            if(dsu.find(u) != dsu.find(v)){
                if(k<=0) return false;

                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);
        for(int node = 1; node<n;node++){
            if(dsu.find(node) != root){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1, 4, 0 }, { 1, 2, 3, 0 }, { 0, 2, 1, 0 } };
        int k = 2;

        System.out.println(maxStability(n, edges, k));
    }
}