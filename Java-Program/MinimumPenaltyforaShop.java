public class MinimumPenaltyforaShop{

    private static int bestClosingTime(String customers){
        int prefix = 0, best_time = 0;
        int maxPenalty = 0;
        int n = customers.length();

        for(int i=0;i<n;i++){
            char ch = customers.charAt(i);
            prefix += ch=='Y' ? 1:-1;

            if(prefix > maxPenalty){
                best_time = i+1;
                maxPenalty = prefix;
            }
        }

        return best_time;
    }
    public static void main(String[] args) {
        String customers = "YYNY";
        System.out.println(bestClosingTime(customers));
    }
}