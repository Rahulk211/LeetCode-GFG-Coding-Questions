import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofVowelsinaSubstringofGivenLength {

        // This is a private static method that takes a string and an integer as input
    // and returns the maximum number of vowels in a substring of the given length
    private static int maxVowels(String s, int k){
        int n = s.length();
        // Create a HashSet to store the vowels
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e');
        set.add('i'); set.add('o');
        set.add('u');
        int maxVowel = 0;
        int cnt =0;
        int i = 0;
        int j = 0;

        //StringBuilder sb = new StringBuilder();
         // Loop through the string with the j pointer
        while(j<n){

            // If the current character is a vowel, increment the count
            if(set.contains(s.charAt(j))){
                cnt++;
            }

            // If the window size (j - i + 1) is equal to k, 
            // it means we have a substring of length k
            if(j-i+1 == k){
                 // Update the maximum number of vowels
                maxVowel = Math.max(maxVowel,cnt);

                // If the character at the i pointer is a vowel, decrement the count
                if(set.contains(s.charAt(i))){
                    cnt--;
                }
                 // Move the i pointer to the right
                i++;
            }
            // Move the j pointer to the right
            j++;
        }

        return maxVowel;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;

        System.out.println(maxVowels(s,k));
    }
}
