import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvaluatetheBracketPairsofaString{

    private static String evaluate(String s, List<List<String>> knowledge){
        Map<String, String> map = new HashMap<>();
        for(List<String> k : knowledge){
            map.put(k.get(0),k.get(1));
        }

        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                int j = s.indexOf(')')+1;
                res.append(map.getOrDefault(s.substring(i+1,j), "?"));
                i=j;
            }
            else{
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string :- ");
        String s = sc.next();

        List<List<String>> knowledge = new ArrayList<>();

        System.out.println("Enter the key and value in knowledge list : ");
        System.out.println("Enter no. of keys :- ");
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            List<String> key_val = new ArrayList<>();
            System.out.println("Enter key");
            String key = sc.next();
            System.out.println("enter val");
            String val = sc.next();

            key_val.add(key);
            key_val.add(val);

            knowledge.add(key_val);
        }

        sc.close();

        String result = evaluate(s, knowledge);

        System.out.println(result);

    }
}