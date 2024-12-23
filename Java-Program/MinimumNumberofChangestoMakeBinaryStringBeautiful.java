import java.util.Scanner;

public class MinimumNumberofChangestoMakeBinaryStringBeautiful{

    private static int minChanges(String s){
        int changes = 0;
        int n = s.length();

        for(int i=0;i<n-1;i=i+2){
            if(s.charAt(i) != s.charAt(i+1)){
                changes++;
            }
        }

        return changes;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary String  : ");
        String s = sc.next();
        sc.close();

        System.out.println("Minimum number of changes : " + minChanges(s));
    }
}