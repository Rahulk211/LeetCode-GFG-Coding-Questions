// Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

// Each letter in magazine can only be used once in ransomNote.

import java.util.Scanner;

public class RansomeNote {
    public boolean ransomNote(String r, String m){
        int[] contain_alpha = new int[26];
        for(char c : r.toCharArray()){
            int i = m.indexOf(c,contain_alpha[c%26]);
            if(i==-1){
                return false;
            }
            contain_alpha[c%26] = i+1;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();

        RansomeNote rn = new RansomeNote();
        System.out.println(rn.ransomNote(str1, str2));
    }
}
