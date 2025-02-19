package Stack;
import java.util.Scanner;
import java.util.Stack;

public class PostfirToInfix {

    public static String PostToInfix(String s){
        Stack<String> stk = new Stack<>();
        int i=0;
        while(i<s.length()){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') ||
              (s.charAt(i)>='a' && s.charAt(i)<='z') ||
              (s.charAt(i)>='0' && s.charAt(i)<='9')){
                // char ch = s.charAt(i);
                stk.push(s);//??
            }
            else{
                String t1 = stk.peek();
                stk.pop();
                String t2 = stk.peek();
                stk.pop();
                String con = "(" + t2 +s.charAt(i) + t1 + ")";
                stk.push(con);
            }
            i++;
        }
        return stk.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid postfix expression: ");
        String str = sc.nextLine();
        System.out.println(PostToInfix(str));
        sc.close();
    }
}
