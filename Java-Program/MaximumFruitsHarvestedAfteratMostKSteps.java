import java.util.Arrays;

public class MaximumFruitsHarvestedAfteratMostKSteps {

    private static int maxTotalFruits(int[][] fruits, int startpos, int k) {
        int n = fruits.length;
        int maxFruits = 0;

        int[] prefix = new int[fruits[n-1][0] + 1];
        Arrays.fill(prefix, 0);
        for(int[] f : fruits){
            prefix[f[0]] += f[1];
        }
        for(int i=1;i<prefix.length;i++){
            prefix[i] += prefix[i-1];
        }
        
        int i=startpos;
        int j = Math.min(startpos + k, prefix.length - 1);

        while(j>=startpos && i>=0){
            int totalFruits = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
            maxFruits = Math.max(maxFruits, totalFruits);
            i--;
            j--;
            if (i < 0) {
                break;
            }
        }
        return maxFruits;
    }
    public static void main(String[] args) {
        int[][] fruits = {{0,9}, {4,1},{5,7},{6,2},{7,4},{10,9}};
        int startpos = 5;
        int k = 4;

        System.out.println(maxTotalFruits(fruits, startpos, k));
    }
}
