// Given an array arr[] denoting heights of N towers and a positive integer K.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by K
// Decrease the height of the tower by K
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

import java.util.Arrays;

public class MinimizetheHeightsII {

    private static int findMinHeight(int[] height, int k){
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Arrays.sort(height);
        int min_dif = height[n-1]-height[0];

        for(int i=1;i<n;i++){
            if(height[i]-k >= 0){
                max = Math.max(height[i-1]+k,height[n-1]-k); // this statement provides to local max height at iteration;
                min = Math.min(height[0]+k,height[i]-k); //this statement provides local min height at every iteration;

                min_dif = Math.min(min_dif,max-min); // always stores the minimum differences of height.
            }

        }

        return min_dif;
    }
    public static void main(String[] args) {
        int[] height = {3,9,12,16,20};
        int k =3;
        System.out.println(findMinHeight(height,k));
    }
}
