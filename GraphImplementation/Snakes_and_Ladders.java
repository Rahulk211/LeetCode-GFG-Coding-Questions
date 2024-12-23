import java.util.LinkedList;
import java.util.Queue;

public class Snakes_and_Ladders {

    private static int snakesAndLadders(int[][] board){
        int n = board.length;
        boolean vis[][] = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[n-1][0] = true;
        int minstep = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size --> 0){
                int curr_val = q.poll();

                if(curr_val==n*n) return minstep;

                for(int dice_val = 1;dice_val<=6;dice_val++){
                    if(dice_val+curr_val > n*n) continue;
                    int[] pos = findCoordinates(dice_val+curr_val,n);
                    int row = pos[0];
                    int col = pos[1];
                    if(vis[row][col]==true)  continue;
                    vis[row][col] = true;

                    if(board[row][col] == -1)  q.add(dice_val+curr_val);
                    else q.add(board[row][col]);
                }
            }
            minstep++;
        }
        return -1;
    }

    private static int[] findCoordinates(int curr, int n){
        int r = n - (curr-1)/n-1;
        int c = (curr-1)%n;

        if(r%2 == n%2) return new int[]{r,n-1-c};
        else return new int[]{r,c};
    }
    public static void main(String[] args) {
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},
        {-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};

        System.out.println(snakesAndLadders(board));
        
            
    }
}
