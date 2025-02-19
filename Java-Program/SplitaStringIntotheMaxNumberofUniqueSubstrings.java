import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {

    static int maxcount;
    private static int maxUniqueSplit(String s){
        maxcount = 0;
        Set<String> set  = new HashSet<>();
        backtrack(s,set,0);

        return maxcount;
    }

    private static void backtrack(String s, Set<String> set, int index){
        int n = s.length();
        if(index == n){
            maxcount = Math.max(maxcount,set.size());
        }

        for(int i=index;i<n;i++){
            String sub = s.substring(index, i+1);
            if(!set.contains(sub)){
                set.add(sub);
                backtrack(s, set, i+1);
                set.remove(sub);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s  = sc.next();
        sc.close();

        System.out.println(maxUniqueSplit(s));
    }    
}
