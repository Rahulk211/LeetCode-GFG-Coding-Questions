public class SmallestPalindromicRearrangementI {
    
    public static String smallestPalindrome(String s) {
        int n = s.length();
        //int half = s/2;
        char[] chars = new char[n];
        int[] freq = new int[26];

        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
        }
        int j=0;
        for(int i=0;i<26;i++){
            while(freq[i]-- > 0){
                System.out.println( i+"  "+ (char)(97+i));
                chars[j] = (char)(97+i);
                chars[n-1-j++] = (char)(97+i);
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "babab";
        System.out.println(smallestPalindrome(s));
    }
}

