import java.util.Scanner;
public class fact {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter a number");
        int n =sc.nextInt();
        long fact=1;
        if(n<=1 ){
            System.out.println(1);
        }
        else{
            for(int i=1;i<=n;i++){
                fact=fact*i;
            }
            System.out.println(fact);
        }
        sc.close();
    }
}
