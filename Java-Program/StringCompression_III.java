
// import java.util.HashMap;
// import java.util.Map;
import java.util.Scanner;

public class StringCompression_III {

    private String compressedString(String s) {
        StringBuilder sb = new StringBuilder();
        // int[] freq = new int[26];
        // for(int i=0;i<s.length();i++){
        // freq[s.charAt(i)-'a'] += 1;
        // }

        // Map<Character,Integer> map = new HashMap<>();
        // for(int i=0;i<s.length();i++){
        // if(freq[s.charAt(i)-'a'] >9){
        // map.put(s.charAt(i), 9);
        // map.put(s.charAt(i), freq[s.charAt(i)-'a']-9);
        // }
        // else{
        // map.put(s.charAt(i), freq[s.charAt(i)-'a']);
        // }
        // }
        // for(Map.Entry<Character,Integer> entry : map.entrySet()){
        // sb.append(entry.getValue());
        // sb.append(entry.getKey());
        // }

        // return sb.toString();
        int cnt = 0;
        char curr = '0';

        for (char c : s.toCharArray()) {
            if (cnt < 9 && c == curr) {
                cnt += 1;
            } else {
                if (cnt > 0) {
                    sb.append(cnt);
                    sb.append(curr);
                }
                cnt = 1;
                curr = c;
            }
        }

        sb.append(cnt);
        sb.append(curr);

        return sb.toString();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();
        StringCompression_III obj = new StringCompression_III();
        System.out.println(obj.compressedString(word));
    }
}
