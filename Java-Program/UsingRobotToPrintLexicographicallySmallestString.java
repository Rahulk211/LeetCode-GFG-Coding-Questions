import java.util.Scanner;
// import java.util.Stack;
import java.util.Stack;

public class UsingRobotToPrintLexicographicallySmallestString {

    private static char sm(int[] freq){
        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                return (char)(i+'a');
            }
        }
        return 'a';
    }
    private static String  robotWithString(String s){
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            stk.push(c);
            freq[c-'a']--;
            while(!stk.isEmpty() && stk.peek() <= sm(freq)){
                result.append(stk.peek());
                stk.pop();
            }
        }
        while(!stk.isEmpty()){
            result.append(stk.pop());
        }
        
        return result.toString();

        // int n = s.length();
        // StringBuilder result = new StringBuilder();
        // PriorityQueue<Character> minHeap = new PriorityQueue<>();
        // for(char c : s.toCharArray()){
        //     minHeap.add(c);
        // }
        // Stack<Character> stk = new Stack<>();
        // for(int i=0;i<n;i++){
        //     char c = s.charAt(i);
        //     stk.push(c);
        //     minHeap.remove(c);
        //     while(!stk.isEmpty() && !minHeap.isEmpty() && stk.peek()<=minHeap.peek()){
               
        //         result.append(stk.peek());
        //         stk.pop();
                
        //     }
        // }
        // while(!stk.isEmpty()){
        //     result.append(stk.pop());
        // }

        // return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println( robotWithString(s));

        sc.close();
    }
}