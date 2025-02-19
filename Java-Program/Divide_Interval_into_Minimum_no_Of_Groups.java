import java.util.Scanner;

public class Divide_Interval_into_Minimum_no_Of_Groups {

    private static int nGroups(int[][] intervals){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        for(int i=0;i<n;i++){
            min = Math.min(min,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
        }

        int events[] = new int[max+2];
        for(int i =0;i<n;i++){
            events[intervals[i][0]]++;
            events[intervals[i][1]+1]--;
        }

        int groups = 0;
        int sum =0;
        for(int i=min;i<max+2;i++){
            sum += events[i];
            groups = Math.max(groups,sum);
        }

        return groups;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                intervals[i][j] = sc.nextInt();
            }
        }

        sc.close();
        nGroups(intervals);
    }
}
