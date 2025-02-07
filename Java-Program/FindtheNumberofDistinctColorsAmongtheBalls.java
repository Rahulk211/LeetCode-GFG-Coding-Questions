import java.util.HashMap;
import java.util.Map;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    private static int[] queryResults(int l, int[][] queries){
        int[] result = new int[queries.length];
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < queries.length; i++){
            int b = queries[i][0];
            int c = queries[i][1];
            if(map1.containsKey(b)){
               int prevcolor = map1.get(b);
               map2.put(prevcolor,map2.get(prevcolor)-1);
               if(map2.get(prevcolor)==0){
                map2.remove(prevcolor);
               }
            }

            map1.put(b,c);
            map2.put(c,map2.getOrDefault(c, 0)+1);
            result[i] = map2.size();
        }

        return result;
    }
    public static void main(String[] args) {
        int limit = 4;
        int[][] queries ={{1,4},{2,5},{1,3},{3,4},{4,5},{2,1}};
        int[] ans = queryResults(limit, queries);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i] + " ");
        }
    }
}
