import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCoveredBuildings {

    private static int countCoveredBuildings(int n, int[][] buildings){
        // int m = buildings.length;
        Map<Integer,List<Integer>> mapx = new HashMap<>(), mapy = new HashMap<>();

        for(int[] building : buildings){
            int x = building[0], y = building[1];

            mapx.computeIfAbsent(x,k -> new ArrayList<>()).add(y);
            mapy.computeIfAbsent(y,k -> new ArrayList<>()).add(x);
        }

        for(List<Integer> lst : mapx.values()){
            Collections.sort(lst);
        }
        for(List<Integer> lst : mapy.values()){
            Collections.sort(lst);
        }
        int cnt = 0;

        for(int[] building : buildings){
            int x = building[0], y = building[1];
            boolean covered = true;

            List<Integer> lstx = mapx.get(x);
            List<Integer> lsty = mapy.get(y);

            int idxx = Collections.binarySearch(lstx, y);
            int idxy = Collections.binarySearch(lsty, x);

            if(idxx == 0 || idxx == lstx.size() - 1) covered = false;
            if(idxy == 0 || idxy == lsty.size() - 1) covered = false;
            if(covered) cnt++;
        }

        return cnt;
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] buildings = {{1,1},{1,2},{2,1},{2,2}};           //[[1,2],[2,2],[3,2],[2,1],[2,3]]

        System.out.println(countCoveredBuildings(n, buildings));
    }
}
