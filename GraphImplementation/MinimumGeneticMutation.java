import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class MinimumGeneticMutation {
    static class Pair{
        String gene ;
        int mutations;

        public Pair(int mutations, String gene){
            this.gene  = gene;
            this.mutations = mutations;
        }
    }

    public static int minMutation(String startgene, String endgene, String[] bank){
        // Set<String> banks = new HashSet<>();
        // for(int i=0;i<bank.length;i++){
        //     banks.add(bank[i]);
        // }
        // if(banks.contains(endgene)){
        //     int cnt =0, i=0;
        //     while(i<startgene.length()){
        //         if(startgene.charAt(i)!=endgene.charAt(i)){
        //             cnt++;
        //         }
        //         i++;
        //     }
        //     return cnt;
        // }
        // else return -1;
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if(!set.contains(endgene)) return -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,startgene));
        char[] arr = {'A','C','G','T'};

        while(!q.isEmpty()){
            Pair p = q.poll();
            String gene = p.gene;
            int mutate = p.mutations;
            if(endgene.equals(gene))  return mutate;
            StringBuilder sb = new StringBuilder(gene);
            for(int i=0;i<gene.length();i++){
                char temp = sb.charAt(i);
                for(char c : arr){
                    sb.replace(i, i+1, c+"");
                    if(set.contains(sb.toString())){
                        q.offer(new Pair(mutate+1, sb.toString()));
                        set.remove(sb.toString());
                    }
                }
                sb.replace(i, i+1, temp+"");
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String startgene = sc.next();
        String endgene = sc.next();
        String[] bank = new String[3];
        for(int i=0;i<3;i++){
            bank[i] = sc.next();
        }
        sc.close();

        System.out.println(minMutation(startgene, endgene, bank));
    }
}
