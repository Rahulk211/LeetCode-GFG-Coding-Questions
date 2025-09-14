import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VowelSpellchecker {

    private static String[] spellchecker(String[] wl, String[] query){
        String[] result = new String[query.length];
        Set<String> set = new HashSet<>(Arrays.asList(wl));
        Map<String, String> l_map = new HashMap<>();
        Map<String, String> v_map = new HashMap<>();
        for(String w : wl){
            String lw = w.toLowerCase();
            l_map.putIfAbsent(lw, w);
            String vw = lw.replaceAll("[aeiou]", "*");
            v_map.putIfAbsent(vw, w);
        }
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            if (set.contains(q)) {
                result[i] = q;
            } else {
                String lq = q.toLowerCase();
                if (l_map.containsKey(lq)) {
                    result[i] = l_map.get(lq);
                } else {
                    String vq = lq.replaceAll("[aeiou]", "*");
                    result[i] = v_map.getOrDefault(vq, "");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        String[] result = spellchecker(wordlist, queries);
        for (String res : result) {
            System.out.println(res);
        }
    }
}
