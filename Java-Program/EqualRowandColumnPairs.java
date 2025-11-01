import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs {

    private static int equalPairs(int[][] grid){
        int n= grid.length;
        int ans = 0;
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]).append(",");
            }
            String rowStr = sb.toString();
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
            System.out.println(map.get(rowStr));
        }



        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[j][i]).append(",");
            }
            String colstr = sb.toString();
            if(map.containsKey(colstr)){
                ans += map.get(colstr);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {11,1},
            {1,11}
        };
        System.out.println("Number of equal row and column pairs: " + equalPairs(grid));
    }
}
