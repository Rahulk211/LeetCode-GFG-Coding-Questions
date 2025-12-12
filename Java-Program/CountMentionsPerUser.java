import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountMentionsPerUser {

    private static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];

       Collections.sort(events, (a, b) -> {

            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            // int cmp = Integer.compare(t1, t2);
            // if (cmp != 0) return cmp;

            // return a.get(0).compareTo(b.get(0));

            if (t1 == t2) {
                char c1 = a.get(0).charAt(1);
                char c2 = b.get(0).charAt(1);

                if (c1 > c2) return -1;
                if (c1 < c2) return 1;
                return 0;
            }

            return Integer.compare(t1, t2);
        });

        for(List<String> event : events){
            String evt = event.get(0);
            if(evt.equals("MESSAGE")){
                applyMessage(event, mentions, offline);
            }

            else{
                int timespt = Integer.parseInt(event.get(1));
                int useId = Integer.parseInt(event.get(2));
                offline[useId] = timespt;
            }
        }

        return mentions;
    }

    private static void applyMessage(List<String> event, int[] mentions, int[] offline){
        int timespt = Integer.parseInt(event.get(1));
        String[] mentionedUsers = event.get(2).split(" ");

        for(String id : mentionedUsers){
            if(id == "ALL"){
                for(int i=0;i<mentions.length;i++){
                    mentions[i]++;
                }
            }

            if(id == "HERE"){
                for(int i=0;i<mentions.length;i++){
                    if(offline[i] == 0 || offline[i] <= timespt){
                        mentions[i]++;
                    }
                }
            }
            else{
                int userId = Integer.parseInt(id.substring(2));
                mentions[userId]++;
            }
        }
    }
    public static void main(String[] args) {
        int numbersOfUsers = 2;
        List<List<String>> events = new ArrayList<>(List.of(
            List.of("MESSAGE","10","id1 id0"),
            List.of("OFFLINE","11","0"),
           List.of("MESSAGE","71","HERE")
        ));

        int[] res = (countMentions(numbersOfUsers, events));

        for(int ans : res){
            System.out.print(ans+" ");
        }
    }
}
