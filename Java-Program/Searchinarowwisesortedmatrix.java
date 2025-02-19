/*
*********Search in a row-wise sorted matrix**********

Given a row-wise sorted 2D matrix mat[][] of size n x m and an integer x,
find whether element x is present in the matrix.
Note: In a row-wise sorted matrix, each row is sorted in itself, i.e. 
for any i, j within bounds, mat[i][j] <= mat[i][j+1].
*/
import java.util.Scanner;

public class Searchinarowwisesortedmatrix {

    private static boolean searchRowMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int target = sc.nextInt();
        sc.close();
        System.out.println(searchRowMatrix(matrix, target));
    }
}
