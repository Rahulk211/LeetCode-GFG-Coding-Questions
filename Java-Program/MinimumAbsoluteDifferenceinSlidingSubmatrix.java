import java.util.TreeSet;

public class MinimumAbsoluteDifferenceinSlidingSubmatrix {

    private static int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] res = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            int limit_i = i + k - 1;

            for (int j = 0; j <= n - k; j++) {
                int limit_j = j + k - 1;
                res[i][j] = findMin(grid, i, j, limit_i, limit_j);
            }
        }

        return res;
    }

    private static int findMin(int[][] grid, int i, int j, int l1, int l2) {
        TreeSet<Integer> set = new TreeSet<>();
        
        for (int r = i; r <= l1; r++) {
            for (int c = j; c <= l2; c++) {
                set.add(grid[r][c]);
            }
        }
        Integer prev = null;
        int min = Integer.MAX_VALUE;
        for (Integer curr : set) {
            if (prev != null) {
                min = Math.min(min, curr - prev);
            }
            prev = curr;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[][] grid = {{ 1, -2 }, { 2, 3 } };
        int k = 2;

        int[][] res = minAbsDiff(grid, k);

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
