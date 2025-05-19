/*
 * You are given two integers m and n. Consider an m x n grid where each cell is initially white. 
 * You can paint each cell red, green, or blue. All cells must be painted.
 * 
 * Return the number of ways to color the grid with no two adjacent cells having the same color. 
 * Since the answer can be very large, return it modulo 109 + 7.
 */

 /*
  * Approach :-  DP with BitMasks
  */
import java.util.Arrays;
import java.util.Scanner;

public class PaintingaGridWithThreeDifferentColors {

    final static int mod = 1000000007;
    static int[][] state_mem = new int[1000+2][1023];

    private static int countWays(int m, int n, int r, int c, int curr_state, int prev_state){
        if(c==n){
            return 1;
        }
        if(r==m){
            return countWays(m, n, 0, c+1, 0, curr_state);
        }
        if(r==0 && state_mem[c][prev_state]!=-1){
            return state_mem[c][prev_state];
        }

        int up_color = 0;
        if(r>0)up_color = curr_state & 3;

        int left_color = (prev_state >> ((m-r-1)*2)) & 3;
        int ways = 0;

        for(int i=1;i<=3;i++){
            if(i != up_color && i != left_color){
                ways = (ways + countWays(m, n, r+1, c, (curr_state<<2) + i, prev_state)) % mod;
            }
        }
        if(r==0){
            state_mem[c][prev_state] = ways;
        }

        return ways;
    }
    private static int colorTheGrid(int m, int n){
        for(int[] i : state_mem){
            Arrays.fill(i, -1);
        }
        return countWays(m, n, 0, 0, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();

        System.out.println(colorTheGrid(m,n));
    }
}
