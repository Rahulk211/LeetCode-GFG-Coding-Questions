import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimumCostFor_Ticket {

    static Set<Integer> set = new HashSet<>();

    private static int helper(int[] days, int[] cost, int curr, int[] dp){
        if(curr > days[days.length-1]) return 0;

        if(dp[curr] != 0){
            return dp[curr];
        }

        if(!set.contains(curr)){
            return helper(days, cost, curr+1, dp);
        }

        int oneday = cost[0] + helper(days, cost, curr+1, dp);
        int sevenday = cost[1] + helper(days, cost, curr+7, dp);
        int thirtyday = cost[2] + helper(days, cost, curr+30, dp);

        return dp[curr] =  Math.min(oneday, Math.min(sevenday, thirtyday));
    }

    private static int mincostTickets(int[] days, int[] cost){
        int last_day = days[days.length-1];
        int[] dp = new int[last_day+1];
        //Arrays.fill(dp, -1);
        //dp[0] = 0;

        for(int day : days)  set.add(day);

        return helper(days, cost, days[0], dp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] cost = new int[3];
        for(int i=0;i<3;i++){
            cost[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(mincostTickets(days,cost));
    }    
}
