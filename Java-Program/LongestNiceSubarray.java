/*
 * You are given an array nums consisting of positive integers.
 * We call a subarray of nums nice if the bitwise AND of every pair of 
 * elements that are in different positions in the subarray is equal to 0.
 * 
 * Return the length of the longest nice subarray.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Note that subarrays of length 1 are always considered nice.
 */

import java.util.Scanner;

public class LongestNiceSubarray {

    private static int longestNiceSubarray(int[] nums){
        int n = nums.length;
        int maxLen = 1;
        int i=0,j=0;
        int curr_sum = 0;
        int xor_sum = 0;
        while(j<n){
            curr_sum +=nums[j];
            xor_sum ^=nums[j];
            while(curr_sum != xor_sum && i<j){
                curr_sum -= nums[i];
                xor_sum ^= nums[i];
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(longestNiceSubarray(nums));

    }
}
