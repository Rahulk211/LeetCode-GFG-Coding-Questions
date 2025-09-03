import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RearrangingFruits {

    private static int minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer,Integer> freq  = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
            min = Math.min(min, Math.min(basket1[i],basket2[i]));
        }

        List<Integer> swap = new ArrayList<>();
        for(Integer key : freq.keySet()) {
            int value = freq.get(key);
            if(value%2 !=0) return -1;
            for(int i=0;i<Math.abs(value)/2;i++){
                swap.add(key);
            }
        }
        Collections.sort(swap);
        int net_cost=0;
        for(int i=0;i<swap.size()/2;i++){
            net_cost += Math.min(min*2, swap.get(i));
        }

        return net_cost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] basket1 = new int[n];
        int[] basket2 = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the number of fruits in basket 1 ");
            basket1[i] = sc.nextInt();
            System.out.println("Enter the number of fruits in basket 1 ");
            basket2[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(minCost(basket1, basket2));

    }
}
