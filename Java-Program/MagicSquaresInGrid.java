import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {
    public static void main(String[] args) {
        int[][] grid = {{7,0,5},{2,4,6},{3,8,1}};     //[7 0 5]
                                                      //[2 4 6]
                                                      //[3 8 1]
        Solution obj = new Solution();

        System.out.println(obj.numMagicSquaresInside(grid));
    }
}

class Solution {

    private static int isMagicSquare(int[][] grid, int i, int j){
        // int n = grid.length;
        // int m = grid[0].length;
        Set<Integer> set = new HashSet<>();
        int[] row = new int[3];
        int[] col = new int[3];

        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(grid[k][l] > 9 || grid[k][l] < 1 || set.contains(grid[k][l])) {
                    return 0;
                }
                set.add(grid[k][l]);
                row[k-i] += grid[k][l];
                col[l-j] += grid[k][l];
            }
        }

        int sum = row[0];
        for(int k=0;k<3;k++){
            if(row[k] != sum || col[k] != sum){
                return 0;
            }
        }

        int dio1=0;
        for(int k=0;k<=2;k++){
            dio1 += grid[i+k][j+k];
        }

        if(dio1 !=sum) return 0;

        int dio2=0;
        for(int k=0;k<3;k++){
            dio2 += grid[i+2-k][j+k];
        }

        if(dio2 !=sum) return 0;

        return 1;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int magicSquares = 0;
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-2;j++){
                magicSquares += isMagicSquare(grid,i,j);
            }
        }

        return magicSquares;
    }
}
