import java.util.ArrayList;
import java.util.List;

public class CheckifGridcanbeCutintoSections{

    public static class Pair{
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private static boolean formLines(List<Pair> coord){
        int lines =0;
        int overlap=0;
        for(Pair p : coord){
            if(p.b==0) overlap--;
            else overlap++;

            if(overlap==0) lines++;
        }
        return lines >=3;
    }

    private static boolean checkValidCuts(int n, int[][] rectangles){
       List<Pair> xcood = new ArrayList<>();
       List<Pair> ycood = new ArrayList<>();

       for(int[] rec : rectangles){
        xcood.add(new Pair(rec[0], 1));
        xcood.add(new Pair(rec[2], 0));
        ycood.add(new Pair(rec[1], 1));
        ycood.add(new Pair(rec[3], 0));
       }

        xcood.sort((a,b) -> {
            if (a.a == b.a) {
                return Integer.compare(a.b, b.b);
            }
            return Integer.compare(a.a, b.a);
        });

        ycood.sort((a,b) -> {
            if (a.a == b.a) {
                return Integer.compare(a.b, b.b);
            }
            return Integer.compare(a.a, b.a);
        });

       for(Pair p : xcood){
        System.out.println(p.a+" "+p.b);
       }
       if(formLines(xcood) || formLines(ycood)){
        return true;
       }
       return false;
    }
    public static void main(String[] args) {
        int n=4;
        int[][] rectangles = {{0,2,2,4},{1,0,3,2},{2,2,3,4},{3,0,4,2},{3,2,4,4}};     //[[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]
        System.out.println(checkValidCuts(n, rectangles));
    }
}
