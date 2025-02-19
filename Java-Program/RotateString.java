import java.util.Scanner;

public class RotateString {

    private static boolean rotateString(String s, String goal){
       if(s.length() != goal.length()){
        return false;
       }

       return (s+s).contains(goal);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string s : ");
        String s = sc.nextLine();
        System.out.print("\nEnter goal string : ");
        String goal = sc.nextLine();
        sc.close();

        System.out.println(rotateString(s, goal));
    }
    
}
