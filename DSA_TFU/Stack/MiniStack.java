package Stack;
import java.util.Stack;

public class MiniStack {
    private Stack<Integer> stk;
    private int minele;

    public MiniStack(){
        stk = new Stack<Integer>();
        minele = Integer.MAX_VALUE;
    }
    public void push(int val) {
        if(stk.empty()){
            minele=val;
            stk.push(val);
        }
        else{
            if(val<minele){
                stk.push(2*val-minele);
                minele = val;
            }
            else{
                stk.push(val);
            }
        }
    }
    public void pop(){
        if(stk.empty()) return;
        int elm = stk.peek();
        stk.pop();
        if(elm<minele){
            minele = 2*minele-elm;
        }
    }
    public int top(){
        if(stk.empty()) return -1;
        int elm =stk.peek();
        if(elm<minele){
            return 2*minele-elm;
        }
        return elm;
    }
    public int getmini(){
        return minele;
    }

    public static void main(String[] args) {
       MiniStack ms=new MiniStack();
       ms.stk.push(0);
       ms.stk.push(-1);
       ms.stk.push(15);
       System.out.println(ms.stk.peek());
       ms.stk.pop();
       System.out.println(ms.stk.peek());


    }
    
}
