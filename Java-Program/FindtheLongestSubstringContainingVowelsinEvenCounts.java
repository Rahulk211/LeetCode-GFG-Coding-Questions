public class FindtheLongestSubstringContainingVowelsinEvenCounts {

    private static int findTheLongestSubstring(String s){
        int maxstring = Integer.MIN_VALUE;
        //int count = 0;
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                freq[ch -'a']++;
            }
        }
        return maxstring;
    }

    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        else return false;
    }

    
    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        int n = findTheLongestSubstring(s);
        System.out.println(n);
    
    }
}
