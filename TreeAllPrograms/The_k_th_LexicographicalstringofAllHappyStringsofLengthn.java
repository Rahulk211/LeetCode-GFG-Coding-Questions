import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class The_k_th_LexicographicalstringofAllHappyStringsofLengthn {

    private static String getHappyString(int n,int k){
        List<String> lst = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("a");
        q.add("b");
        q.add("c");
        while(!q.isEmpty()){
            String str = q.poll();
            if(str.length()==n){
                lst.add(str);
                continue;
            }
            if(str.charAt(str.length()-1)=='a'){
                q.add(str+"b");
                q.add(str+"c");
            }
            else if(str.charAt(str.length()-1)=='b'){
                q.add(str+"a");
                q.add(str+"c");
            }
            else{
                q.add(str+"a");
                q.add(str+"b");
            }
        }
        //Collections.sort(lst);
        if(k>lst.size()) {
            return "";
        }
        else{
            return lst.get(k-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(getHappyString(n,k));
    }
}
