/*
You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, 
nums becomes a Zero Array. If no such k exists, return -1.
*/

import java.util.Scanner;

public class ZeroArrayTransformation_II {
    private static boolean currentIndexZero(int[] nums, int[][] queries, int r){
        int n=nums.length;
        int[] sweep = new int[n+1];
        for(int i=0;i<r;i++){
            int li = queries[i][0];
            int ri = queries[i][1];
            int vali = queries[i][2];
            sweep[li] += vali;
            sweep[ri+1] -= vali;
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += sweep[i];
            if(sum<nums[i]){
                return false;
            }
        }
        return true;
    }
    private static int minZeroArray(int[] arr, int[][] queries){
        int left =0;
        int right = queries.length;

        if(!currentIndexZero(arr, queries, right)) return -1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(currentIndexZero(arr, queries, mid)){
                right = mid -1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[][] queries = new int[m][3];
        for(int i=0;i<m;i++){
            queries[i][0]=sc.nextInt();
            queries[i][1]=sc.nextInt();
            queries[i][2]=sc.nextInt();
        }
        sc.close();

        System.out.println(minZeroArray(arr, queries));
    }
}
