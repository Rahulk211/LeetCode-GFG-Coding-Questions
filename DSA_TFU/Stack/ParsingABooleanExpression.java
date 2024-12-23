package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ParsingABooleanExpression {

    private static char evaluate(List<Character> list, char opr){
        if(opr == '&'){
            if(find(list,'f')){
                return 'f';
            }
            else{
                return 't';
            }
        }

        else if(opr == '|'){
            if(find(list,'t')){
                return 't';
            }
            else{
                return 'f';
            }
        }

        else{
            return (list.get(0)=='t'?'f':'t');
        }
    }

    private static boolean find(List<Character> list , char val){
        for(char ch : list){
            if(ch == val){
                return true;
            }
        }
        return false;
    }

    private static boolean parseBoolean(String str){
        Stack<Character> stk = new Stack<>();
        int n = str.length();
        for(int i = 0; i < n; i++){
            char ch = str.charAt(i);
            if(ch == ')'){
                List<Character> list = new ArrayList<>();
                while(stk.peek()!='('){
                    list.add(stk.pop());
                }
                stk.pop();
                char opr = stk.pop();
                stk.push(evaluate(list,opr));
            }
            else {
                if(ch!=','){
                    stk.push(ch);
                } 
            }
        }

        return stk.pop()=='t'?true:false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        boolean result = parseBoolean(str);
        System.out.println(result);
    }
}
