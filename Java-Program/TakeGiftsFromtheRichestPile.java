
import java.util.PriorityQueue;
import java.util.Scanner;

public class TakeGiftsFromtheRichestPile {

    private static long pickGifts(int[] gifts, int k){
        // PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        //     public int compare(int a[], int b[]){
        //         return (b[0]-a[0]);
        //     }
        // });
        // for(int i=0;i<gifts.length;i++){
        //     pq.add(new int[]{gifts[i],i});
        // }
        // int remaining = 0;
        // for (int i = 0; i < k; i++) {
        //     int arr[] = pq.poll();
        //     gifts[arr[1]]=(int)Math.floor(Math.sqrt(arr[0])); 
        //     pq.add(new int[] {gifts[arr[1]], arr[1]});
        // }
        // for(int i=0;i<gifts.length;i++){
        //     System.out.println(gifts[i]);
        //     remaining+=gifts[i];
        // }
        // return remaining;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }
        for(int i=0;i<k && pq.peek()>1;i++){
            int num = pq.poll();
            pq.add((int)Math.floor(Math.sqrt(num)));
        }
        long sum =0;
        for(int num : pq){
            sum +=num;
        }
        return sum;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] gifts = new int[n];
        for(int i=0;i<n;i++){
            gifts[i]=sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(pickGifts(gifts, k));
    }
}
