import java.util.Scanner;

public class Rotate_by_90_degree {

    static void rotate(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int top = 0;
        int bottom = n-1;
        while(top<bottom){
            for(int i=0;i<n;i++){
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }
            top++;
            bottom--;
        }

        // int left = 0;
        // int right = n-1;
        // while(left<right){
        //     for(int row =0;row<n;row++){
        //         int temp = matrix[row][left];
        //         matrix[row][left] = matrix[row][right];
        //         matrix[row][right] = temp;
        //     }
        //     left++;
        //     right--;
        // }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        sc.close();

        rotate(matrix);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
