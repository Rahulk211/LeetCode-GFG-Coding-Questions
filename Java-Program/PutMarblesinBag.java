import java.util.Arrays;

public class PutMarblesinBag {

    private static int putMarbles(int[] weights, int k){
        int n = weights.length;
        int m = n-1;
        int[] pairsum = new int[m];
        for(int i=0;i<m;i++){
            pairsum[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairsum);
        int minsum=0;
        int maxsum=0;

        for(int i=0;i<k-1;i++){
            minsum +=pairsum[i];
            maxsum +=pairsum[m-1-i];
        }

        return maxsum-minsum;

    }
    public static void main(String[] args) {
        int[] weights = {1,3,5,1};
        int k=2;
        System.out.println(putMarbles(weights, k));
    }
}
