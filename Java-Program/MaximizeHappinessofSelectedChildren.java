import java.util.Arrays;

public class MaximizeHappinessofSelectedChildren {

    private static long maximumHappinessSum(int[] happiness, int k){
        int n = happiness.length;
        long ans = 0;
        int depth=0;

        Arrays.sort(happiness);

        for(int i=n-1;i>=0 && k-->0;i--){
            int val = (happiness[i] - depth);
            if(val < 0) break;
            ans += val;
            depth++;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 2;

        System.out.println(maximumHappinessSum(happiness, k));
    }
}
