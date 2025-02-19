/*
 * You are given a 0-indexed integer array arr, and an m x n integer matrix mat. 
 * arr and mat both contain all the integers in the range [1, m * n].
 * Go through each index i in arr starting from index 0 and 
 * paint the cell in mat containing the integer arr[i].
 * Return the smallest index i at which either a row or a column will be completely painted in mat.

 
 */

import java.util.HashMap;
import java.util.Map;

public class FirstCompletelyPaintedRoworColumn {

    static class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int firstCompleteIndex(int[] arr, int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        int[] row_count = new int[m];
        int[]col_count = new int[n];
        Map<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            Pair pair = map.get(num);
            row_count[pair.x]++;
            col_count[pair.y]++;
            if(row_count[pair.x] == n || col_count[pair.y] == m){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,8,7,4,1,3,5,6,9};
        int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};

        System.out.println(firstCompleteIndex(arr, mat));
    }
}
