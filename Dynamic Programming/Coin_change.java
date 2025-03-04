public class Coin_change {

    private static int coinschange(int[] coins, int amount){
        if(amount<1){
            return 0;
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            
            for(int coin : coins){
                if(coin<=i && dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = {9, 6, 5, 1};
        int amount = 11;
        System.out.println(coinschange(coins, amount));
    }
    
}
