import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineifTwoStringsAreClose {

    private static boolean closeStrings(String w1, String w2){
        int n1 = w1.length();
        int n2 = w2.length();

        if(n1 != n2){
            return false;
        }

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0;i<n1;i++){
            char ch1 = w1.charAt(i);
            char ch2 = w2.charAt(i);

            set1.add(ch1);
            set2.add(ch2);

            count1[ch1 - 'a']++;
            count2[ch2 - 'a']++;
        }

        if(!set1.equals(set2)){
            return false;
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
    public static void main(String[] args) {
        String w1 = "cabbba";
        String w2 = "abbccc";

        System.out.println(closeStrings(w1, w2));
    }
}
