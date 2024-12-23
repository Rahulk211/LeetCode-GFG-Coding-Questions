import java.util.Scanner;
import java.lang.Math;
public class prime {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n;
        boolean j=true;
        System.out.println("Enter a number");
        n= sc.nextInt();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                System.out.println("not a prime number");
                j=false;
                break;
            }
        }
        if(j==true){
            System.out.println("It is a prime number");
        }
        sc.close();
    }
}
