import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    private static List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastIdx = new int[26];
        for(int i=0;i<n;i++){
            lastIdx[s.charAt(i)-'a'] = i;
        }

        List<Integer> list = new ArrayList<>();

        int i=0;
        while(i<n){
            int end = lastIdx[s.charAt(i)-'a'];
            int j=i;
            while(j<end){
                if(lastIdx[s.charAt(j)-'a']>end){
                    end = lastIdx[s.charAt(j)-'a'];
                }
                j++;
            }
            list.add((end-i)+1);
            i = end+1;
        }
        return list;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
