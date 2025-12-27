import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public static void main(String[] args) {
        int n = 3;
        int[][] meetings = { { 1, 20 }, { 2, 10 }, { 3, 5 }, { 4, 9 }, { 6, 8 } }; // [[1,20],[2,10],[3,5],[4,9],[6,8]]

        Solutions obj = new Solutions();

        System.out.println(obj.mostBooked(n, meetings));
    }
}

class Solutions {
    static class Pair {
        int endTime;
        int room;

        public Pair(int endTime, int room) {
            this.endTime = endTime;
            this.room = room;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] room_used = new int[n];
        PriorityQueue<int[]> meeting = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int[] mtgs : meetings) {
            meeting.add(mtgs);
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            rooms.offer(i);
        }

        PriorityQueue<Pair> mtgs = new PriorityQueue<>((a, b) -> {
            if (a.endTime == b.endTime)
                return a.room - b.room;
            return a.endTime - b.endTime;
        });

        int maxCount = 0, maxRoom = 0;

        while (!meeting.isEmpty()) {
            int[] meet = meeting.poll();
            int st = meet[0], ed = meet[1];

            while (!mtgs.isEmpty() && mtgs.peek().endTime <= st) {
                rooms.offer(mtgs.poll().room);
            }
            if (!rooms.isEmpty()) {
                int idx = rooms.poll();
                mtgs.offer(new Pair(ed, idx));
                room_used[idx]++;

            } else {
                Pair rm = mtgs.poll();
                int newEnd = rm.endTime + (ed - st);
                mtgs.offer(new Pair(newEnd, rm.room));
                room_used[rm.room]++;
            }
        }

        for (int idx = 0; idx < n; idx++) {
            if (room_used[idx] > maxCount) {
                maxCount = room_used[idx];
                maxRoom = idx;
            }
        }
        return maxRoom;
    }
}
