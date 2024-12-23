import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairWithSmallestSum{

    private static List<List<Integer>> findPair(int[] num1,int[] num2, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] i1,int[] i2){
                return Integer.compare(i1[0],i2[0] );
            }  
        });
        pq.add(new int[]{num1[0]+num2[0],0,0});
        List<List<Integer>> res = new ArrayList<>();
        Set<String> vis = new HashSet<>();

        while(!pq.isEmpty() && k>0){
            int[] curr = pq.poll();
            int idx1 = curr[1];
            int idx2 = curr[2];
            List<Integer> temp = new ArrayList<>();
            temp.add(num1[idx1]);
            temp.add(num2[idx2]);
            res.add(temp);
            k--;
            if(idx2+1<num2.length && !vis.contains(idx1+","+(idx2+1))){
                pq.add(new int[]{num1[idx1]+num2[idx2+1],idx1,idx2+1});
                vis.add(idx1+","+(idx2+1));
            }
            if(idx1+1<num1.length && !vis.contains((idx1+1)+","+idx2)){
                pq.add(new int[]{num1[idx1+1]+num2[idx2],idx1+1,idx2});
                vis.add((idx1+1)+","+idx2);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int num1[] = {1,2,4,5,6};
        int num2[] = {3,5,7,9};
        int k=3;
        
        List<List<Integer>> list = findPair(num1,num2,k);
        System.out.println(list);
    }
}