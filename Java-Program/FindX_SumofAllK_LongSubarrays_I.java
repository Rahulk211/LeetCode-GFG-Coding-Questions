// import java.util.HashMap;
// import java.util.Map;
// import java.util.PriorityQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindX_SumofAllK_LongSubarrays_I{

static class Pair {
    int val;
    int freq;

    Pair(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
}

    private static int findSum(Map<Integer, Integer> freq, int x){
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.freq == b.freq){
                return b.val - a.val; // Descending order of values if frequencies are equal
            }
            else{
                return b.freq - a.freq; // Ascending order of frequencies
            }
        });

        // for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
        //    System.out.println(entry.getKey() + " : " + entry.getValue());
        // }

        // System.out.println("end");

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        for(int i=0;i<x;i++){
            if(!pq.isEmpty()){
                Pair p = pq.poll();
                sum += p.val * p.freq;
            }
        }

        return sum;
        
    }


    private static int[] findXSum(int[] nums, int k, int x){
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int i=0, j=0;

        List<Integer> result = new ArrayList<>();

        while(j<n){
            int val = nums[j];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            if(j-i+1 > k){
                freq.put(nums[i], freq.get(nums[i])-1);
                if(freq.get(nums[i]) <= 0){
                    freq.remove(nums[i]);
                }
                i++;
            }
            if(j-i+1 == k){
                // int[] res = XSum(nums, i, j);
                int ans = findSum(freq, x);
                result.add(ans);

            }
            j++;
        }

        // Convert List to array
        int[] resArr = new int[result.size()];
        for(int idx=0; idx<result.size(); idx++){
            resArr[idx] = result.get(idx);
        }
        return resArr;

    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,3,2};
        int k = 6;
        int x = 2;

        int[] res = findXSum(nums, k, x);
        for(int val : res){
            System.out.print(val + " ");
        }
    }
}