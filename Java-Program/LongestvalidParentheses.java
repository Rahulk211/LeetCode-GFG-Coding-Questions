// Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

// A parenthesis string is valid if:

// For every opening parenthesis, there is a closing parenthesis.
// Opening parenthesis must be closed in the correct order.

// Input: str = ((()
// Output: 2
// Explaination: The longest valid parenthesis substring is "()".

//import java.util.Stack;

public class LongestvalidParentheses {

    private static int maxLength(String s){
        int n = s.length();
        int mxop = 0;
        int mxcl = 0;
        int op =0;
        int cl = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                op++;
            } 
            else{
                cl++;
            }
            if(cl>op){
                op = 0;
                cl = 0;
            }
            if(cl == op){
                mxop = Math.max(mxop, op*2);
            }
        }
        cl =0;
        op =0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == '('){
                op++;
            } 
            else{
                cl++;
            }
            if(cl<op){
                op = 0;
                cl = 0;
            }
            if(cl == op){
                mxcl = Math.max(mxcl, op*2);
            }
        }

        return Math.max(mxop,mxcl);
    }
    public static void main(String[] args) {
        String str = ")()())"; 
        System.out.println(maxLength(str));
    }
}
