public class MinimumTimetoMakeRopeColorful {

    private static int minCost(String colors, int[] neededTime){
        int n = colors.length();
        int totalCost = 0;
        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalCost += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        for(int i=0;i<n;i++){
            System.out.print(neededTime[i]+" ");
        }
        return totalCost;
    }
    public static void main(String[] args) {
        String colors = "aaabbbabbbb";
        int[] neededTime = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        
        System.out.println(minCost(colors, neededTime));
    }
}
