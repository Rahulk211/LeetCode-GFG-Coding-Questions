import java.util.Scanner;

public class Facingthesun {

    private static int countBuilding(int[] height){
        int maxheight = height[0];
        int cnt = 1;

        for(int i=1;i<height.length;i++){
            if(height[i] > maxheight){
                cnt++;
                maxheight = height[i];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i =0;i<n;i++){
            height[i] = sc.nextInt();
        }

        sc.close();

        System.out.println(countBuilding(height));
    }
}
