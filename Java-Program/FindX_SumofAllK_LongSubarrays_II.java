import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FindX_SumofAllK_LongSubarrays_II {

    private static long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];

        Map<Integer, Integer> freq = new HashMap<>();
        TreeSet<Integer> xset = new TreeSet<>((a, b) -> {
            int fa = freq.getOrDefault(a, 0), fb = freq.getOrDefault(b, 0);
            if (fa != fb)
                return Integer.compare(fa, fb);
            return Integer.compare(a, b);
        });

        TreeSet<Integer> rest = new TreeSet<>((a, b) -> {
            int fa = freq.getOrDefault(a, 0), fb = freq.getOrDefault(b, 0);
            if (fa != fb)
                return Integer.compare(fa, fb);
            return Integer.compare(a, b);
        });

        long xsum = 0L;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int fr = freq.getOrDefault(val, 0);
            if (fr > 0) {
                if (xset.remove(val)) {
                    xsum -= fr * val;
                } else {
                    rest.remove(val);
                }
            }

            freq.put(val, fr+1);
            rest.add(val);

            xsum = balanceSets(xset, rest, freq, x, xsum);

            if(i>=k){
                int st = nums[i-k];
                int frst = freq.get(st);

                if(xset.remove(st)){
                    xsum -= (long)frst * st;
                } else {
                    rest.remove(st);
                }

                if(frst==1){
                    freq.remove(st);
                } else {
                    freq.put(st, frst-1);
                    rest.add(st);
                }

                xsum = balanceSets(xset, rest, freq, x, xsum);
            }

            if(i>=k-1){
                ans[i-k+1] = xsum;
            }
        }

        return ans;
    }

    private static long balanceSets(TreeSet<Integer> xset, TreeSet<Integer> rest, Map<Integer, Integer> freq, int x, long xsum) {
        while(xset.size() < x && !rest.isEmpty()){
            int val = rest.last();
            rest.remove(val);
            int fr = freq.get(val);
            xset.add(val);
            xsum += (long)fr * val;
        }

        while(xset.size()>x){
            int val = xset.first();
            xset.remove(val);
            rest.add(val);
            int fr = freq.get(val);
            xsum -= (long)fr * val;
        }

        while(!xset.isEmpty() && !rest.isEmpty()){
            int wstx = xset.first();
            int bst = rest.last();
            int frx = freq.get(wstx);
            int frb = freq.get(bst);

            if(frb >frx || (frb == frx && bst > wstx)){
                xset.remove(wstx);
                rest.add(wstx);
                xset.add(bst);
                rest.remove(bst);
                xsum += (long)frb * bst - (long)frx * wstx;
            } else {
                break;
            }
        }
        return xsum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 4, 2, 3 };
        int k = 6;
        int x = 2;

        long[] res = findXSum(nums, k, x);
        for (long val : res) {
            System.out.print(val + " ");
        }
    }
}
