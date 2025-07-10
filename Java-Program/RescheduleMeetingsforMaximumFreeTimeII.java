import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RescheduleMeetingsforMaximumFreeTimeII {

    static class Pair{
        int gap;
        int idx;

        public Pair(int gap, int idx){
            this.gap = gap;
            this.idx = idx;
        }
    }

    private static int getFreeTime(int i, int[] st, int[] ed, List<Pair> top3){
        int last_end = (i==0) ? 0 : ed[i-1];
        int meetDuration = ed[i] - st[i];
        int nextStart = st[i+1];
        int ogGap = nextStart - last_end;

        for(Pair p : top3){
            if(p.gap >= meetDuration && p.idx != i && p.idx != i+1){
                return ogGap;
            }
        }

        return ogGap - meetDuration;
    }

    private static int maxFreeTime(int eventTime, int[] start, int[] end){
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

        int n = start.length;
        List<Pair> top3 = new ArrayList<>();
        top3.add(new Pair(start[0]-0, 0));
        top3.add(new Pair(-1, -1));
        top3.add(new Pair(-1, -1));

        for(int i=1;i<n;i++){
            Pair gap = new Pair(start[i] - end[i-1], i);
            if(gap.gap > top3.get(2).gap){
                top3.set(2, gap);
                Collections.sort(top3, (a,b) -> b.gap-a.gap);
            }
        }

        int max_freetime=0;
        for(int i=0;i<n-1;i++){
            int freetime = getFreeTime(i, start, end, top3);
            max_freetime = Math.max(max_freetime, freetime);
        }
        
        return max_freetime;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter event time");
        int eventTime = sc.nextInt();
        
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

        System.out.println(maxFreeTime(eventTime, startTime, endTime));
    }
}
