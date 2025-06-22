import java.util.Scanner;

public class MaximumManhattanDistanceAfterKChanges {

    private static int count(int a,int b, int c){
        return Math.abs(a-b) + c*2;
    }

    private static int maxDistance(String s, int k){
        int nt=0,st=0,et=0,wt=0;
        int ans = 0;

        for(char c:s.toCharArray()){
            switch(c){
                case 'N':
                    nt++;
                    break;
                case 'S':
                    st++;
                    break;
                case 'E':
                    et++;
                    break;
                case 'W':
                    wt++;
                    break;
            }

            int t1 = Math.min(Math.min(nt,st), k);
            int t2 = Math.min(Math.min(et,wt), k-t1);

            ans = Math.max(ans, count(nt,st, t1) + count(et,wt,t2));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        sc.close();

        System.out.println(maxDistance(s,k));
    }
}
