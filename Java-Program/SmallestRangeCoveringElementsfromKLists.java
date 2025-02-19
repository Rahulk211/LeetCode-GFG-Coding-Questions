import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SmallestRangeCoveringElementsfromKLists {

    public static int[] smallestRange(List<List<Integer>> nums){
        int[] result= {-10000,10000};
        int k = nums.size();
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));

        for(int i=0;i<k;i++){
            int mx = nums.get(i).get(0);
            int[] toBeAdded = {mx, i, 0};
            pq.offer(toBeAdded);
            max = Math.max(max,mx);
        }

        while(true){
            int[] rge = pq.poll();
            if(result[1]-result[0] > max - rge[0]){
                result[0]=rge[0];
                result[1]= max;
            }
            rge[2]++;
            List<Integer> l = nums.get(rge[1]);
            if (rge[2]==l.size()) {
                break;
            }
            else{
                rge[0] = l.get(rge[2]);
                max = Math.max(max,l.get(rge[2]));
                pq.add(rge);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of k");
        int k = sc.nextInt();
        List<List<Integer>> nums = new ArrayList<>();
        for(int i=0;i<k;i++){
            System.out.println("Enter the size of list "+(i+1));
            int n=sc.nextInt();
            List<Integer> l = new ArrayList<>();
            for(int j=0;j<n;j++){
                l.add(sc.nextInt());
            }
            nums.add(i,l);
        }
        sc.close();
            //[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        int[] res = smallestRange(nums);
        System.out.println("\n\n[" + res[0] + "," + res[1] + "]");
    }
    
}
