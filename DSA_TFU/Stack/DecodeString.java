package Stack;

import java.util.Stack;

public class DecodeString {

    private static String decodeString(String s){
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder();
                while(stk.peek() != '['){
                    sb.insert(0, stk.pop());
                }
                stk.pop(); 
                StringBuilder num = new StringBuilder();
                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    num.insert(0, stk.pop());
                }
                int cnt = Integer.parseInt(num.toString());
                String str = sb.toString();
                for(int j=0;j<cnt;j++){
                    for(int k=0;k<str.length();k++){
                        stk.push(str.charAt(k));
                    }
                }
            }else{
                stk.push(s.charAt(i));
            }
        }
        while(!stk.isEmpty()){
            res.insert(0, stk.pop());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        String encoded = "3[a]2[c]";
        System.out.println(decodeString(encoded));
    }
}
