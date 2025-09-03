import java.util.Map;
import java.util.Scanner;

public class FruitIntoBaskets {

    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> fruitCount = new java.util.HashMap<>();
        int left = 0, maxFruits = 0;
        for (int right = 0; right < n; right++) { //[1,2,3,2,2]
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(totalFruit(arr));
    }
}
