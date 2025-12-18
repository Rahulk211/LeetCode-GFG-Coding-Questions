public class BestTimetoBuyandSellStockusingStrategy {

    private static long maxProfit(int[] prices, int[] strategy, int k){
        int n = prices.length;
        int[] profit = new int[n];
        long og_profit = 0;

        for(int i=0;i<n;i++){
            profit[i] = prices[i] * strategy[i];
            og_profit += prices[i] * strategy[i];
        }

        int i=0, j=0;
        long ogpft = 0, mdpft = 0, maxgain = 0;

        while(j<n){
            ogpft += profit[j];
            if(j-i+1 > k/2){
                mdpft += prices[j];
            }

            if(j-i+1 > k){
                ogpft -= profit[i];
                mdpft -= prices[i+(k/2)];
                i++;
            }

            if(j-i+1 == k){
                maxgain = Math.max(maxgain, mdpft - ogpft);

            }

            j++;
        }

        return og_profit + maxgain;
    }
    public static void main(String[] args) {
        int[] prices = {4,7,13};
        int[] strategy = {-1,-1,0};
        int k=2;

        System.out.println(maxProfit(prices, strategy, k));
    }
}
