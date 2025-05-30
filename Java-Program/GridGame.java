/*
 * You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] 
 * represents the number of points at position (r, c) on the matrix. 
 * Two robots are playing a game on this matrix.
 * 
 * Both robots initially start at (0, 0) and want to reach (1, n-1).
 * Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).
 * 
 * At the start of the game, the first robot moves from (0, 0) to (1, n-1), 
 * collecting all the points from the cells on its path. For all cells (r, c) 
 * traversed on the path, grid[r][c] is set to 0. Then, the second robot moves from 
 * (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may 
 * intersect with one another.
 * 
 * The first robot wants to minimize the number of points collected by the second robot. 
 * In contrast, the second robot wants to maximize the number of points it collects. 
 * If both robots play optimally, return the number of points collected by the second robot.
 * 
 */
import java.util.Scanner;

public class GridGame {

    private static long gridGame(int[][] grid){
        int n = grid[0].length;
        long topsum = 0;
        long minsum = Long.MAX_VALUE;
        long bottomsum = 0;
        for(int i=0;i<n;i++){
            topsum += grid[0][i];
        }

        for(int i=0;i<n;i++){
            topsum -= grid[0][i];
            minsum = Math.min(minsum, Math.max(topsum, bottomsum));
            bottomsum += grid[1][i];
        }

        return minsum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[][] grid = new int[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        sc.close();

        System.out.println(gridGame(grid));
    }
}
