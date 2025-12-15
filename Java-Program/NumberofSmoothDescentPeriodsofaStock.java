public class NumberofSmoothDescentPeriodsofaStock {

    private static long getDescentPeriods(int[] price){
        int n = price.length;
        int i=0, j=0;
        long res = 0;

        while(j<n){
            if(j==0){
                i = 0;
                j++;
                res++;
                continue;
            }
            if(price[j] == price[j-1]-1){
                res += j - i + 1;
                j++;
            }
            else{
                i=j;
                res++;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] price = {1};
        System.out.println(getDescentPeriods(price));
    }
}
