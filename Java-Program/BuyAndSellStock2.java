public class BuyAndSellStock2 {

    public static int maxProfit(int[] price){
        int n= price.length;
        
        int totalprofit=0;
        for(int i=1;i<n;i++){
            int maxprofit=0;
           // buy=Math.min(buy, price[i]);
           // System.out.println(buy);
            int buy=price[i-1];
            maxprofit=Math.max(maxprofit, price[i]-buy);
            //System.out.println("maxprice"+maxprofit);
            totalprofit += maxprofit; 
        }
        return totalprofit;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
