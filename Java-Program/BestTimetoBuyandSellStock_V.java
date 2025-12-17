public class BestTimetoBuyandSellStock_V {
    static long[][][] dp = new long[1001][501][3];

    private static long solve(int i, int k, int cases, int[] prices) {
        if(i >= prices.length){
            if(cases == 0)  return 0;

            return Integer.MIN_VALUE;
        }

        if(dp[i][k][cases] != Integer.MIN_VALUE)  return dp[i][k][cases];

        long dont_take =0, take=0; 

        dont_take = solve(i+1, k, cases, prices);

        if(k>0){
            if(cases == 1){
                take = prices[i] + solve(i+1, k -1, 0, prices);
            }

            else if(cases == 2){
                take = -prices[i] + solve(i+1, k - 1, 0, prices);
            }

            else{
                take = Math.max(prices[i] + solve(i+1, k, 2, prices),
                    -prices[i] + solve(i+1, k, 1, prices));
            }
        }

        return dp[i][k][cases] = Math.max(take, dont_take);
    }

    private static long maximumProfit(int[] prices, int k){

        for(int i=0;i<1001;i++){
            for(int j=0;j<501;j++){
                for(int l=0;l<3;l++){
                    dp[i][j][l] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(0, k, 0, prices);
    }

    
    public static void main(String[] args) {
        int[] prices = {1,7,9,8,2};
        int k = 2;
        System.out.println(maximumProfit(prices, k));
    }
}
