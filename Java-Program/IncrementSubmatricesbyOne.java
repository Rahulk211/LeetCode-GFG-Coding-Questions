public class IncrementSubmatricesbyOne {

    // private static void fillMatrix(int[][] mat, int r1, int c1, int r2,int c2){
    //     for(int i=r1;i<=r2;i++){
    //         for(int j=c1;j<=c2;j++){
    //             mat[i][j]++;
    //         }
    //     }
    // }

    private static int[][] incrementSubmatrices(int n, int[][] query){
        int[][] mat = new int[n][n];
        // for(int[] q : query){
        //     int r1=q[0], c1=q[1], r2=q[2], c2=q[3];
        //     fillMatrix(mat, r1, c1, r2, c2);
        // }
        // return mat;

        for(int[] q:query){
            int r0 = q[0], c0 = q[1], r1 = q[2]+1, c1 = q[3]+1;
            mat[r0][c0] ++;
            if(c1<n)mat[r0][c1]--;
            if(r1<n){
                if(c1<n)
                    mat[r1][c1]++;
                mat[r1][c0]--;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                mat[i][j] += mat[i][j-1];
            }
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                mat[i][j] += mat[i-1][j];
            }
        }

        return mat;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] quries = {{1,1,2,2},{0,0,1,1}};
        int[][] res = incrementSubmatrices(n, quries);
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
