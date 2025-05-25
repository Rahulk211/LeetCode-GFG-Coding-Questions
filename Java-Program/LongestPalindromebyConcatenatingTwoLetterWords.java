
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromebyConcatenatingTwoLetterWords {

    private static String reverseWord(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(1));
        sb.append(s.charAt(0));

        return sb.toString();
    }

    private static int longestPalindrome(String[] words){

        Map<String, Integer> map = new HashMap<>();
        int result =0;

        for(String s : words){
            String rs = reverseWord(s);
            if(map.containsKey(rs)){
                result += 4;
                int val = map.get(rs);
                map.put(rs, val-1);
                if(map.get(rs)<=0){
                    map.remove(rs);
                }
            }
            else map.put(s, map.getOrDefault(s, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String s = entry.getKey();
            int i = entry.getValue();

            if(s.charAt(0)==s.charAt(1) && i > 0){
                result+=2;
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String[] words = {"qo","fo","fq","qf","fo","ff","qq","qf","of"
        ,"of","oo","of","of","qf","qf","of"};

        System.out.println(longestPalindrome(words));
    }
}
