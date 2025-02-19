import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringWithoutRepeation {

    public int LongestSubstring(String s){
        int start=0;
        int maxlen = 0;
        Map<Character,Integer> map = new HashMap<>();

        for(int end=0;end<s.length();end++){
            if(!map.containsKey(s.charAt(end)) || map.get(s.charAt(end))<start){
                map.put(s.charAt(end), end);
                maxlen = Math.max(maxlen, end-start+1);
            }
            else{
                start = map.get(s.charAt(end))+1;
                map.put(s.charAt(end),end);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str =sc.nextLine();
        sc.close();

        LongestSubstringWithoutRepeation obj = new LongestSubstringWithoutRepeation();
        System.out.println(obj.LongestSubstring(str));

    }
    
}
