import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprialMatrix {
    public static List<Integer> sprialMatrix(int[][] matrix,int m,int n) {
        if(matrix.length==0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();

        int left=0,top=0;
        int right = m-1;
        int bottom=n-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] matrix = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        sc.close();

    List<Integer> list = sprialMatrix(matrix,m,n);
    System.out.println(list);
    }    
}
