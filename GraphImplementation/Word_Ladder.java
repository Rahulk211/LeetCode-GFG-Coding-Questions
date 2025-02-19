import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Word_Ladder {
    static class Pair{
        String st;
        int level;

        Pair(String st, int lvl){
            this.st = st;
            this.level = lvl;
        }
    }

    private static int ladderLength(String start, String end, String[] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 1));
        set.remove(start);

        while(!q.isEmpty()){
            Pair p = q.poll();
            String wrd = p.st;
            int level = p.level;

            if(wrd.equals(end)==true)  return level;

            StringBuilder sb = new StringBuilder(wrd);
            for(int i=0;i<wrd.length();i++){
                char temp = sb.charAt(i);
                for(char c='a';c<='z';c++){
                    if (c != temp) { // Avoid replacing the character with itself
                        sb.setCharAt(i, c);
                        if(set.contains(sb.toString())) {
                            set.remove(sb.toString());
                            q.add(new Pair(sb.toString(), level + 1));
                        }
                    }
                }
                sb.setCharAt(i, temp);
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting string : ");
        String start = sc.next();
        System.out.print("Enter ending string : ");
        String end = sc.next();
        System.out.print("enter the size of words array : ");
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter word "+(i+1)+" : ");
            words[i] = sc.next();
        }
        sc.close();

        System.out.println(ladderLength(start, end, words));
    }
}
