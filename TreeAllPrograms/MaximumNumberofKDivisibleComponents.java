/*There is an undirected tree with n nodes labeled from 0 to n - 1. You are given the integer n 
and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates
that there is an edge between nodes ai and bi in the tree.

You are also given a 0-indexed integer array values of length n, 
where values[i] is the value associated with the ith node, and an integer k.

A valid split of the tree is obtained by removing any set of edges, possibly empty,
from the tree such that the resulting components all have values that are divisible by k, 
where the value of a connected component is the sum of the values of its nodes.

Return the maximum number of components in any valid split. 
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumNumberofKDivisibleComponents {

    private static int dfs(List<List<Integer>> adj, int[] values,int k, int[] cnt, int curr, int parent){
        int sum = values[curr];
        for(int child: adj.get(curr)){
            if(child != parent){
                sum += dfs(adj, values, k, cnt, child, curr);
            }
        }
        if(sum % k == 0) cnt[0]++;
        return sum%k;
    } 

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] nums : edges){
            adj.get(nums[0]).add(nums[1]);
            adj.get(nums[1]).add(nums[0]);
        }
        int[] component_cnt = new int[1];
        dfs(adj, values, k, component_cnt, 0, -1);
        return component_cnt[0]; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        int[][] edge = new int[n][2];
        
        for(int i=0;i<n-1;i++){
            System.out.println("Enter edges");
            for(int j=0;j<2;j++){
                edge[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter k");
        int k = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Enter values");
        for(int i=0;i<n;i++){
            values[i] = sc.nextInt();
        }
        sc.close();

        System.out.println( maxKDivisibleComponents(n,edge,values,k));
    }
}
