import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ImplementRouter {
    public static void main(String[] args) {
        int n = 3;
        Router obj = new Router(n);
        System.out.println(obj.addPacket(1, 4, 90));
        System.out.println(obj.addPacket(2, 5, 90));
        System.out.println(obj.addPacket(1, 4, 90));
        System.out.println(obj.addPacket(3, 5, 95));
        System.out.println(obj.addPacket(4, 5, 105));
        int[] param_2 = obj.forwardPacked();
        System.out.println(param_2[0] + " " + param_2[1] + " " + param_2[2]);
        System.out.println(obj.addPacket(5, 2, 110));
        System.out.println(obj.getCount(5,100, 105));
    }       
}

// [1,4,90],[2,5,90],[1,4,90],[3,5,95],[4,5,105],[],[5,2,110],[5,100,110]

class Router {

    // static class Packet{
    // int source;
    // int dest;
    // int ts;

    // Packet(int source, int dest, int ts){
    // this.source = source;
    // this.dest = dest;
    // this.ts = ts;
    // }
    // }

    // static Queue<Packet> queue;
    static Queue<int[]> queue;
    static Map<String, Integer> pkt;
    static Map<Integer, List<Integer>> map;
    static int k;

    public Router(int memorylimit) {
        queue = new LinkedList<>();
        k = memorylimit;
        pkt = new HashMap<>();
        map = new HashMap<>();
    }

    public boolean addPacket(int source, int dest, int ts) {
        String key = source + "," + dest + "," + ts;
        if (pkt.containsKey(key)) {
            return false;
        } else {
            if (queue.size() == k) {
                int[] p = queue.poll();
                pkt.remove(key);
                map.remove(p[1]);
            }
            queue.add(new int[] { source, dest, ts });
            pkt.put(key, 1);
            map.putIfAbsent(dest, new LinkedList<>());
            map.get(dest).add(ts);
            System.out.println(map);
            return true;
        }
    }

    public int[] forwardPacked() {
        if (!queue.isEmpty()) {
            int[] p = queue.poll();
            String key = p[0] + "," + p[1] + "," + p[2];
            pkt.remove(key);
            map.get(p[1]).remove(map.get(p[1]).indexOf(p[2]));

            return new int[] { p[0], p[1], p[2] };
        }

        return new int[] {};

    }

    public int getCount(int dest,int start, int end) {
        int cnt = 0;
        if (!map.containsKey(dest)) return 0;
        List<Integer> ts = map.get(dest);  
        System.out.println(ts);  
        for (int t : ts) {
            if (t >= start && t <= end) cnt++;
        }  

        return cnt;
    }

    public static int find(int t, List<Integer> list){
        int l=0;
        int h=list.size()-1;
        while(l<h){
            int mid=(l+h)/2;
            if(list.get(mid)==t) return mid;
            else if(list.get(mid)<t) l=mid+1;
            else h=mid;
        }
        return -1;
    }

}
