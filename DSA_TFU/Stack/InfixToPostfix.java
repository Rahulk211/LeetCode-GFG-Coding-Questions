package Stack;

//Infix to postfix conversion.

// time complexity : O(n)
//Space complexity : O(N)

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

    public static int Priority(char s){
        if(s=='+' || s=='-'){
            return 1;
        }
        else if(s=='*' || s=='/'){
            return 2;
        }
        else if(s=='^'){
            return 3;
        }
        
        return -1;
    }
    public static StringBuilder Postfix(String s){
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n= s.length();
        int i=0;
        while(i<n){
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || 
                (s.charAt(i)>='a' && s.charAt(i)<='z') ||
                (s.charAt(i)>='0' && s.charAt(i)<='9')){
                    sb.append(s.charAt(i));
                }
            else if(s.charAt(i)=='('){
                stk.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                while(!stk.empty() && stk.peek()!='('){
                    sb.append(stk.peek());
                    stk.pop();
                }
                stk.pop();
            }
            else{
                if(!stk.empty() && Priority(s.charAt(i))<=Priority(stk.peek()) ){
                    sb.append(stk.peek());
                    stk.pop();
                }
                stk.push(s.charAt(i));
            }
            i++;
        }
        while(!stk.isEmpty()){
            sb.append(stk.peek());
            stk.pop();
        }
        return sb;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter yout string");
        String s = sc.nextLine();
        sc.close();

        StringBuilder ans = Postfix(s);
        System.out.println();
        System.out.println(ans);
    }
}
