package Stack;
import java.util.Scanner;
import java.util.Stack;

public class ValidateParanthesis {

    public boolean ValidateString(String s){
        Stack<Character> stk = new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stk.push(s.charAt(i));
            }
            else if(stk.empty()){
                return false;
            }
            else if(stk.peek()=='(' && s.charAt(i)==')'){
                stk.pop();
            }
            else if(stk.peek()=='{' && s.charAt(i)=='}'){
                stk.pop();
            }
            else if(stk.peek()=='[' && s.charAt(i)==']'){
                stk.pop();
            }
        }
        if(stk.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ex-({[]})");
        String str = sc.nextLine();
        sc.close();
        ValidateParanthesis vp = new ValidateParanthesis();
        boolean flag = vp.ValidateString(str);
        System.out.println(flag);
    }
}
