import java.util.Scanner;

public class RotatingtheBox {

    private static char[][] rotateTheBox(char[][] box){
        int m = box.length, n = box[0].length;
        char[][] res = new char[box[0].length][box.length];
        for(int i = 0; i < m; i++){
            char[] row = applyGravity(box[i]);
            for(int j=0;j<n;j++){
                res[j][m-1-i] = row[j];
            }
        }
        return res;
    }

    private static char[] applyGravity(char[] row){
        int n = row.length;
        int stones = 0, cells = 0;
        for(int i=0;i<n;i++){
            if(row[i] == '*'){
                int j=i-1;
                while(cells-->0){
                    if(stones!=0){
                        row[j--] = '#';
                        stones--;
                    }
                    else row[j--] = '.';
                }
            }
            else if(row[i] == '#'){
                stones++;
            }
            cells++;
        }
        int j = row.length-1;
        while(cells-->0){
            if(stones>0){
                row[j--] = '#';
                stones--;
            }
            else row[j--] = '.';
        }
        return row;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] box = new char[m][n];
        for(int i=0;i<m;i++){
            String s = sc.next();
            for(int j=0;j<n;j++){
                box[i][j] = s.charAt(0);
            }
        }
        sc.close();

        char[][] rotated = rotateTheBox(box);
        for(int i = 0; i < rotated.length; i++){
            for(int j = 0; j < rotated[0].length; j++){
                System.out.print(rotated[i][j]);
            }
            System.out.println();
        }
    }
}
