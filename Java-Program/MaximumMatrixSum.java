public class MaximumMatrixSum {
    private static long maxMatrixSum(int[][] matrix){
        int n = matrix.length;
        int negatives = 0;
        long posSum = 0;
        long negSum = 0;
        int minpos = Integer.MAX_VALUE;
        int maxneg =Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] < 0){
                    negSum -= (matrix[i][j]);
                    negatives++;
                    maxneg = Math.max(maxneg, matrix[i][j]);
                }
                else{
                    posSum += (matrix[i][j]);
                    minpos = Math.min(minpos, matrix[i][j]);
                }
            }
        }

        if((negatives&1) == 0) return posSum+negSum;
        else return posSum+negSum -(2*Math.min(-maxneg,minpos));
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(maxMatrixSum(matrix));
    }
    
}
