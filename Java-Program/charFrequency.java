import java.util.HashMap;
//import java.util.HashSet;
import java.util.Scanner;

public class charFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        // char[] ch = str.toCharArray();
        // int[] freq = new int[26];
        // for (int i = 0; i < ch.length; i++) {
        //     freq[ch[i] - 'a']++;
        // }
        // for(int i= 0;i<26;i++){
        //     if(freq[i]!=0){
        //         System.out.println(freq[i]);
        //     }
        // }

        HashMap<String,Integer> set = new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(set.containsKey(str.charAt(i)+"")){
                set.put(str.charAt(i)+"",set.get(str.charAt(i)+"")+1);
            }
            else{
                set.put(str.charAt(i)+"",1);
            }
        }
        for(String key:set.keySet()){
            System.out.println(key+" : "+set.get(key));
        }
        sc.close();
    }
    
}
