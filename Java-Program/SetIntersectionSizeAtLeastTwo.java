// import java.util.ArrayList;
import java.util.Arrays;
// import java.util.List;

public class SetIntersectionSizeAtLeastTwo {

    private static int intersectionSizeTwo(int[][] intervals){
        int n = intervals.length;
        
        Arrays.sort(intervals,(a, b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            else return a[1] - b[1];
        });
        
        int cnt = 2;
        int[] maxi = new int[2];
        maxi[0] = intervals[0][1]-1;
        maxi[1] = intervals[0][1];

        for(int i=1;i<n;i++){
            if(maxi[1] < intervals[i][0]){
                cnt += 2;
                maxi[0] = intervals[i][1]-1;
                maxi[1] = intervals[i][1];
            }
            else if(maxi[0] < intervals[i][0]){
                cnt += 1;
                maxi[0] = maxi[1];
                maxi[1] = intervals[i][1];
            }
        }

        return cnt;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {3,7}, {8,9}};

        System.out.println(intersectionSizeTwo(intervals));
    }
}
