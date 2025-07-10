import java.util.Scanner;

public class FindtheKthCharacterinStringGame_I {

   
    private static char kthCharacter(int k){
        int op = k/2;
        return 'a';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.close();

        System.out.println(kthCharacter(k));
    }
}
