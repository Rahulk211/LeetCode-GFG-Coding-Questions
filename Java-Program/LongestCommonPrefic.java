import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefic {

    public static int[] commanPrefix(String[] s){
        if(s.length<=1){
            return new int[] {0};
        }
        Arrays.sort(s);
        int n=0;

        while(n<s[0].length() && n<s[s.length-1].length()){
            String word1 = s[0];
            String word2 = s[s.length-1];
            if(word1.charAt(n)==word2.charAt(n)){
                n++;
            }
            else break;
        }

        return new int[] {0,n};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i]=sc.next();
        }
        sc.close();
        int[] cp = commanPrefix(str);

        for(int i=0;i<cp[1];i++){
            System.out.print(str[0].charAt(i)+" ");
        }

    }
    
}
