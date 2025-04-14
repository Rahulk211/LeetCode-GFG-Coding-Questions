import java.util.Arrays;

public class MinimumOperationstoMakeaUniValueGrid {

    private static int minOperations(int[][] grid,int x){
        int n = grid.length;
        int m = grid[0].length;
        int rem = grid[0][0] %x;
        int[] nums = new int[m*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]%x!=rem){
                    return -1;
                }
                nums[i*m+j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int mid = nums.length/2;
        int steps =0;
        for(int i=0;i<m*n;i++){
            steps += (Math.abs(nums[i]-nums[mid]))/x;
        }
        return steps;

    }
    public static void main(String[] args) {
        int[][] grid = {{1,2},{3,4}};
        int x =2;
        System.out.println(minOperations(grid,x));
    }
}
