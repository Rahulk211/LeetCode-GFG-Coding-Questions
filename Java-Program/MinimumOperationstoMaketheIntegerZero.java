import java.util.Scanner;

public class MinimumOperationstoMaketheIntegerZero {

    private static int makeTheIntegerZero(int num1, int num2){
        for(int i=0;i<60;i++){
            long rem = num1*1L - i*num2*1L;
            if(rem<i){
                return -1;
            }
            if(i>=Long.bitCount(rem)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        sc.close();

        System.out.println(makeTheIntegerZero(num1, num2));
    }
}