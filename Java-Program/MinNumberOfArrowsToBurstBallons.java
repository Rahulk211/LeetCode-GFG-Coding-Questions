import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinNumberOfArrowsToBurstBallons {

    public static int miniStack(int[][] points){
        int arrows = 1;
        Arrays.sort(points,Comparator.comparing((i)->i[0]));
        int[] prev = points[0];

        for(int i=1;i<points.length;i++){
            int currsp=points[i][0];
            int currep=points[i][1];
            int prevsp = prev[0];
            int prevep = prev[1];

            if(prevep>currsp){
                arrows++;
                prev = points[i];
            }
            else{
                prev[0] = Math.max(prevsp,currsp);
                prev[1] = Math.min(prevep,currep);
            }
        }
        return arrows;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] points = new int [size][2];
        for(int i=0;i<size;i++){
            for(int j=0;j<2;j++){
                points[i][j]=sc.nextInt();
            }
        }
        sc.close();
        System.out.println(miniStack(points));
    }
}
