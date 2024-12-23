import java.util.Scanner;

public class MakeStringaSubsequenceUsingCyclicIncrements{

    private static boolean canMakeSubsequence(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        //StringBuilder sb = new StringBuilder(str1);
        int i = 0, j = 0;
        while(i < n && j < m){
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(j);
            if(s1 == s2){
                j++;
            }
            if(s1=='z'){
                if('a'==s2)
                j++;
            }
            else if(s1+1==s2){
                j++;
            }
            i++;
        }
        return j == m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        sc.close();

        System.out.println(canMakeSubsequence(str1,str2));
    }
}