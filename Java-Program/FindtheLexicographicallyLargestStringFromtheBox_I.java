/*
 * You are given a string word, and an integer numFriends.
 * Alice is organizing a game for her numFriends friends. There are multiple rounds in the game, where in each round:
 * 
 * word is split into numFriends non-empty strings, such that no previous round has had the exact same split.
 * All the split words are put into a box.
 * Find the lexicographically largest string from the box after all the rounds are finished.
 */

import java.util.Scanner;

public class FindtheLexicographicallyLargestStringFromtheBox_I {

    private static String answerString(String word, int numfriends){
        int n = word.length();
        int maxlen = n-numfriends+1;
        // StringBuilder sb = new StringBuilder();
        // for(int i=0;i<n;i++){
        //     if(i < maxlen){
        //         sb.append(word.charAt(i));
        //         System.out.println(sb.charAt(sb.length()-1));
        //     } else {
                
        //         if(word.charAt(i) > sb.charAt(sb.length()-1)){
        //             sb.setCharAt(sb.length()-1, word.charAt(i));
        //         }
        //     }
        // }
        // List<String> splits = new ArrayList<>();
        
        // for(int i=0;i<n;i++){
        //     StringBuilder sb = new StringBuilder();
        //     
        //     if (i + maxlen < n) {
        //          sb.append(word.substring(i, i+maxlen)) ;
        //          splits.add(sb.toString()); 
        //     }
        //     else{
        //         sb.append(word.substring(i, ));
        //         splits.add(sb.toString());
        //     }

        // }
        // // Find the lexicographically largest string from the splits
        // Collections.sort(splits);
        // StringBuilder result = new StringBuilder(splits.get(splits.size() - 1));
        // return result.toString();

        String res ="";
        for(int i=0;i<n;i++){
            String temp;
            if(i + maxlen < n) {
                temp = word.substring(i, i + maxlen);
            } else {
                temp = word.substring(i);
            }
            if(temp.compareTo(res) > 0){
                res = temp;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String word = sc.nextLine();
        int numfriends = sc.nextInt();
        sc.close();

        System.out.println(answerString(word, numfriends));
    }
}
