import java.util.Arrays;
public class LargestSubmatrixWithRearrangements{

    private static int largestSubmatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]>=1 && matrix[i-1][j] >=1){
                    matrix[i][j]+=matrix[i-1][j];
                }
            }
        }

        int maxArea = 0;
        for(int[] row : matrix){
            maxArea = Math.max(maxArea, findArea(row));
        }
        return maxArea;
    }

    private static int findArea(int[] row){
        Arrays.sort(row);
        int st=0, ed = row.length-1;
        while(st<ed){
            int temp = row[st];
            row[st] = row[ed];
            row[ed] = temp;
            st++;
            ed--;
        }
        int area =0;
        for(int i=0;i<row.length;i++){
            area = Math.max(area, row[i]*(i+1));
            
        }
        return area;
    }
    public static void main(String[] args) {
        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};

        System.out.println(largestSubmatrix(matrix));
    }
}