import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class FindAllPeopleWithSecret {

    private static List<Integer> findAllPeople(int n, int[][] mts, int fp){
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for(int[] m : mts){
            map.computeIfAbsent(m[2], k -> new ArrayList<>()).add(new int[]{m[0],m[1]});
        }

        boolean[] ks = new boolean[n];
        ks[0] = true;
        ks[fp] = true;

        for(int t : map.keySet()){
            Map<Integer, List<Integer>> mp = new HashMap<>();

            for(int[] m: map.get(t)){
                int x = m[0], y=m[1];
                mp.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                mp.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            Set<Integer> set = new HashSet<>();
            for(int[] m : map.get(t)){
                int x = m[0], y= m[1];
                if(ks[x]) set.add(x);
                if(ks[y]) set.add(y);
            }

            Queue<Integer> q = new LinkedList<>(set);
            while(!q.isEmpty()){
                int psn = q.poll();
                for(int nextpsn : mp.getOrDefault(psn, new ArrayList<>())){
                    if(!ks[nextpsn]){
                        ks[nextpsn] = true;
                        q.offer(nextpsn);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(ks[i]) result.add(i);
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,8}};
        int firstperson = 1;

        System.out.println(findAllPeople(n, meetings, firstperson));
    }
    
}
