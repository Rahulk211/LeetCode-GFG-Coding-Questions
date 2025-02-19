import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LongestCommonPrefixAfterRemovalaStringFromList {

    private static String findPrefix(List<String> st){
        String s="";
        Collections.sort(st);
        String word1 = st.get(0);
        String word2 = st.get(st.size()-1);
        for(int i=0;i<word1.length();i++){
            if(word1.charAt(i)==word2.charAt(i)){
                s=s+word1.charAt(i);
            }
            else{
                break;
            }
        }
        return s;
    }

    private static List<String> longestCommonPrefix(List<String> str){
        if(str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<str.size();i++){
            String s = str.remove(i);
            String prefix = findPrefix(str);
            res.add(prefix);
            str.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String s = sc.next();
            list.add(s);
        }
        sc.close();
        System.out.println(longestCommonPrefix(list));
    }
}
