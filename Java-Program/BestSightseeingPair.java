public class BestSightseeingPair {

    private static int maxScoreSightseeingPair(int[] values){
        int n = values.length;
        int[] i_values = new int[n];
        int[] prefixMax = new int[n];
        int maxScore = 0;
        for(int i=0;i<n;i++){
            i_values[i] = values[i]+i;
        }
        prefixMax[0] = values[0];
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1], i_values[i]);
        }
        for(int i=1;i<n;i++){
            maxScore = Math.max(maxScore, prefixMax[i-1]+values[i]-i);
        }
        return maxScore;
    }
    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));
    }
    
}
