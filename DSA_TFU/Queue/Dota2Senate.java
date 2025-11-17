package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    private static String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> Rq = new LinkedList<>();
        Queue<Integer> Dq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                Rq.add(i);
            } else {
                Dq.add(i);
            }
        }

        while (!Rq.isEmpty() && !Dq.isEmpty()) {
            int r = Rq.poll();
            int d = Dq.poll();
            // System.out.println("Radiant index: " + r + ", Dire index: " + d);

            if (r < d) {
                Rq.add(r+n);
            } else {
                Dq.add(d+n);
            }
        }

        return Rq.isEmpty() ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate = "RDD";

        System.out.println(predictPartyVictory(senate));
    }
}
