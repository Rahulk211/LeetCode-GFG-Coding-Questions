import java.util.Scanner;

public class CheckifNumberisaSumofPowersofThree {

    private static boolean checkPowersOfThree(int n){
        if(n<3){
            return false;
        }
        while(n!=1){
            if(n%3==2){
                return false;
            }
            n = n/3;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(checkPowersOfThree(n));
    }
}
