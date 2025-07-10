import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RescheduleMeetingsforMaximumFreeTimeI{

    private static int maxFreeTime(int eventTime, int k, int[] start, int[] end){
        if(eventTime > start[start.length-1]){
            int[] newstart = new int[start.length+1];
            int[] newend = new int[start.length+1];
            System.arraycopy(start, 0, newstart,0, start.length);
            System.arraycopy(end, 0, newend, 0, start.length);
            newstart[start.length] = eventTime;
            newend[start.length] = eventTime;

            start = newstart;
            end = newend;
        }

        int m = start.length;
        int i=0;
        int win_sum=0, max_sum =0;
        int last_end = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while(i<m){
            win_sum += (start[i] - last_end);
            max_sum = Math.max(max_sum, win_sum);
            dq.addLast(start[i] - last_end);
            while(dq.size() > k){
                win_sum -=dq.removeFirst();
            }
            last_end = end[i];
            i++;
        }

        return max_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter event time");
        int eventTime = sc.nextInt();
        System.out.println("Enter k");
        int k = sc.nextInt();
        System.out.println("enter n");
        int n = sc.nextInt();

        int startTime[] = new int[n];
        int[] endTime = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("enter start time");
            startTime[i] = sc.nextInt();
            System.out.println("enter end time");
            endTime[i] = sc.nextInt();
        }

        sc.close();

        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }
}