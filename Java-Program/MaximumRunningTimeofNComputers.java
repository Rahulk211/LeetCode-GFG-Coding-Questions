import java.util.Arrays;

public class MaximumRunningTimeofNComputers {

    private static boolean canRun(long time, int n, int[] batteries){
        long contri = 0;
        for(int battery : batteries){
            contri += Math.min(battery, time);

            if(contri >= n*time){
                return true;
            }
        }
        return false;
    }

    private static long maxRunTime(int n, int[] batteries){
        Arrays.sort(batteries);
        long low = 0;
        long high = 100_000_000_000_000L;
        long result = 0;

        while(low <= high){
            long mid = (high + low)/2;
            if(canRun(mid, n, batteries)){
                low = mid + 1;
                result = Math.max(mid, result);
            }
            else{
                high = mid-1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 3; 
        int[] batteries = {10,10,3,5};

        System.out.println(maxRunTime(n, batteries));
    }
}
