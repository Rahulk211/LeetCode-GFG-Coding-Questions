import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FindMinimumDiameterAfterMergingTwoTrees{

    private static int minimumDiameterAfterMerge(int[][] ed1,int[][] ed2){
        int[] tree1_height = findMinHeight(ed1.length+1, ed1);
        int[] tree2_height = findMinHeight(ed2.length+1, ed2);

        return Math.max(Math.max(tree1_height[1],tree2_height[1]),(tree1_height[0]+tree2_height[0]+1));
    }

    public static int[] findMinHeight(int n, int[][] ed){
        if(n<=2) return new int[]{n-1,n-1};
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edg : ed){
            adj.get(edg[0]).add(edg[1]);
            degree[edg[0]]+=1;
            adj.get(edg[1]).add(edg[0]);
            degree[edg[1]]+=1;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i] == 1) q.add(i);
        }
        int heigth=0,LastLevelsize = 0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur = q.remove();
                for(int nei : adj.get(cur)){
                    degree[nei]-=1;
                    if(degree[nei] == 1) q.add(nei);
                }
                LastLevelsize = size;
                heigth += 1;
            }
        }
        heigth -= 1;
        int dia = 2*heigth;
        if(LastLevelsize>1){
            heigth+=1;
            dia+=1;
        }
        return new int[]{heigth,dia};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edges1 = new int[n][2];
        for(int i=0;i<n;i++){
            edges1[i][0]=sc.nextInt();
            edges1[i][1]=sc.nextInt();
        }
        int m = sc.nextInt();
        int[][] edges2 = new int[m][2];
        for(int i=0;i<m;i++){
            edges2[i][0]=sc.nextInt();
            edges2[i][1]=sc.nextInt();
        }
        sc.close();
        System.out.println("Minimum diameter: - "+minimumDiameterAfterMerge(edges1,edges2));
    }
}