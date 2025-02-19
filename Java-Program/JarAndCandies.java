import java.util.Scanner;

class JarAndCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = 5, n = 10;
        int purchased;

        do {

            System.out.println("enter the number of candies to be purchased :- ");
            purchased = sc.nextInt();
            if(purchased==0) break;
            if (purchased > n) {
                System.out.println("Invalid input");

            } 
            else {
                System.out.println("Number of candies sold : " + purchased);
                System.out.println("Number of candies avaliable : " + (n- purchased));
                if ((n- purchased) <= k) {
                    n = 10;
                    System.out.println("jar refilled");
                }
            }
        } while (purchased != 0);

        sc.close();

    }
}