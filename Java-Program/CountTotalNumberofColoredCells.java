import java.util.Scanner;

public class CountTotalNumberofColoredCells {

    private static long coloredCells(int n){
        long res = (long)n;
        return ((res*res)+((res-1)*(res-1)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(coloredCells(n));
    }
}
