import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class SortMatrixbyDiagonals{

    private static void sortMatrixByDiagonals(int[][] grid){
        int n = grid.length;
        for(int i=0;i<n;i++){
            List<Integer> dig = new ArrayList<>();
            int i1 = i;
            int j=0;
            while(i1<n && j<n){
                dig.add(grid[i1][j]);
                i1++;
                j++;
            }
            Collections.sort(dig);
            Collections.reverse(dig);
            
            i1=i;
            j=0;
            while(i1<n && j<dig.size()){
                grid[i1][j]=dig.get(j);
                i1++;
                j++;
            }
        }

        for(int j1=1;j1<n;j1++){
            List<Integer> dig = new ArrayList<>();
            int j2=j1;
            int i=0;
            while(i<n && j2<n){
                dig.add(grid[i][j2]);
                i++;
                j2++;
            }
            
            Collections.sort(dig);
            j2=j1;
            i=0;
            while(j2<n && i<dig.size()){
                grid[i][j2]=dig.get(i);
                i++;
                j2++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] grid ={{1,7,3},{9,8,2},{4,5,6}};   //[[1,7,3],[9,8,2],[4,5,6]]
        sortMatrixByDiagonals(grid);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}