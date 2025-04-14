public class SolvingQuestionsWithBrainpower {

    private static int mostPoints(int[][] questions){
        int n = questions.length;
        int[] dp = new int[n];
        dp[0] = questions[0][0];
        dp[1] = questions[1][0];
        dp[2] = questions[2][0];

        for(int i=3;i<n;i++){
            dp[i] = dp[i-3]+questions[i][0];
        }

        return Math.max(dp[n-3], Math.max(dp[n-2],dp[n-1]));
    }
    public static void main(String[] args) {
        int[][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};

        System.out.println(mostPoints(questions));
    }
}
