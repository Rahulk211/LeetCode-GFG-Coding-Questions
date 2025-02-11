/*KMP is an pattern matching algo the finds out that the pattern is present in the given string or not.
 * it uses a pi or lps table to do so 
 */
public class KMPAlgorithm {

    private static int[] computeLPSArray(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int j = 0; // index for the pattern
        int i = 1; // index for the lps array
        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i++] = ++j;
                
            }
            else{
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }

            }
        }
        return lps;
    }

    private static boolean findPatten(String s,String p,int[] lps){
        int n = s.length();
        int m = p.length();
        int j = 0; // index for the pattern
        int i = 0; // index for the string
        while(i < n){
            if(p.charAt(j) == s.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                return true;
            }
            else if(i < n && p.charAt(j) != s.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String text = "ABACDABACDABABCABAB";
        String pattern = "AABB";
        int[] lps = computeLPSArray(pattern);

        System.out.println(findPatten(text,pattern,lps));
    }
}
