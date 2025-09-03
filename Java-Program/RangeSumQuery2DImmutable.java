public class RangeSumQuery2DImmutable {

    static int[][] prefix;

    public RangeSumQuery2DImmutable(int[][] matrix){
        int n=matrix.length;
        int m=matrix[0].length;
        prefix = matrix;

        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
                prefix[i][j]+=prefix[i][j-1];
            }
        }

        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                prefix[i][j]+=prefix[i-1][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = prefix[row2][col2];
        int extra1 = (col1 > 0) ? prefix[row2][col1 - 1] : 0;
        int extra2 = (row1 > 0) ? prefix[row1 - 1][col2] : 0;
        int extra3 = (row1 > 0 && col1 > 0) ? prefix[row1 - 1][col1 - 1] : 0;

        return total - extra1 - extra2 + extra3;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        RangeSumQuery2DImmutable obj = new RangeSumQuery2DImmutable(matrix);
        System.out.println(obj.sumRegion(1, 1, 2, 2)); 
        
    }
}
