import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FlipColumnsForMaximumNumberofEqualRows {

    private static int maxEqualRowsAfterFlips(int[][] matrix){
        Map<String,Integer> map = new HashMap<>();
        for(int[] row : matrix){
            StringBuilder values = new StringBuilder();
            StringBuilder flipped = new StringBuilder();
            for(int value : row){
                values.append(value);
                flipped.append(1-value);
            }
            map.put(values.toString(), map.getOrDefault(values.toString(), 0)+1);
            map.put(flipped.toString(), map.getOrDefault(flipped.toString(), 0)+1);
        }
        int res = 0;
        for(int v : map.values()){
            res = Math.max(res, v);
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(maxEqualRowsAfterFlips(matrix));
    }
}
