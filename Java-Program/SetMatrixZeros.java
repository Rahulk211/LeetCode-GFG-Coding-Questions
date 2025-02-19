public class SetMatrixZeros {

    private static void setMatrixZero(int[][] matrix){
        // int rows = matrix.length;
        // int col = matrix[0].length;

        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<col;j++){
        //         if(matrix[i][j] == 0){
        //             setZero(matrix, i, j);
        //         }
        //     }
        // }
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<col;j++){
        //         if(matrix[i][j] == -1){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0) {
                    row[i]=1;
                    col[j]=1;
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (row[i]==1 || col[j]==1) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    // private static void setZero(int[][] matrix,int row,int col){
    //     for(int i=0;i<matrix[0].length;i++){
    //         if(matrix[row][i]!= 0){
    //             matrix[row][i] = -1;
    //         }
    //     }
    //     for(int i=0;i<matrix.length;i++){
    //         if(matrix[i][col]!= 0){
    //             matrix[i][col] = -1;
    //         }
    //     }
    // }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setMatrixZero(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
