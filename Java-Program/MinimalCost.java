/*There is an array arr of heights of stone and Geek is standing at the first stone 
and can jump to one of the following: Stone i+1, i+2, ... i+k stone, 
where k is the maximum number of steps that can be jumped and cost will be |hi-hj| is incurred,
where j is the stone to land on. Find the minimum possible total cost incurred before 
the Geek reaches the last stone.
 */

public class MinimalCost {

    private static int minCost(int[] arr,int k){
        //int mincost = 0;
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = Math.max(0,i-k);j<i;j++){
                min = Math.min(min,dp[j]+Math.abs(arr[i]-arr[j]));
            }
            dp[i] = min;
        }
        return dp[n-1];

    }
    public static void main(String[] args) {
        int[] arr = {10,30,40,50,20};
        int k = 3;
        System.out.println(minCost(arr,k));
    }
}
