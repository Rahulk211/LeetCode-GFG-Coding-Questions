import java.util.Arrays;

public class MaximizeHappinessofSelectedChildren {

    private static int maximumHappinessSum(int[] happiness, int k){
        int n = happiness.length;
        int ans = 0, dec = 0;

        Arrays.sort(happiness);

        for(int i=n-1;i>=0;i--){
            int happy = (happiness[i] - dec);
            if(happy < 0) ans += 0;
            else{
                ans += happy;
            }
            dec++;
            k--;
            if(k==0) break;
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 2;

        System.out.println(maximumHappinessSum(happiness, k));
    }
}
