import java.util.Scanner;
import java.util.Stack;

public class ConstructSmallestNumberFromDIString{
    private static String smallestNumber(String pattern){
        int n = pattern.length();
        Stack<Integer> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=n;i++){
            stk.push(i+1);
            if(i==n || pattern.charAt(i)=='I'){
                while(!stk.isEmpty()){
                    sb.append(stk.pop());
                }
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.next();
        sc.close();
        System.out.println(smallestNumber(pattern));

    }
}