package Stack;

import java.util.Stack;

public class BasicCalculator {

    private static int eval(String s){
        Stack<Integer> stk = new Stack<>();
        int sum=0,sign =1;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                val=val*sign;
                sign=1;
                sum+=val;
            }
            else if(ch=='('){
                stk.push(sum);
                stk.push(sign);
                sum=0;
                sign = +1;
            }
            else if(ch==')'){
                sum*=stk.pop();
                sum+=stk.pop();
            }
            else if(ch=='-'){
                sign*=-1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "5+(4-1)";
        System.out.println(eval(s));
    }
    
}
