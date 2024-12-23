
// Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

// Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

// The tests are generated such that there is exactly one solution. You may not use the same element twice.

// Your solution must use only constant extra space.

import java.util.Scanner;

public class TwoSumIISortedArray {
    public static int[] towSumII(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        int sum=0;
        while(right>left){
            sum = nums[right]+nums[left];
            if(sum==target){
                return new int[] {left+1,right+1};
            }
            else if(sum>target){
                right--;
            }
            else{
                left++;
            }
        }
        return new int[] {-1,-1};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] numbers = new int[size];
        for(int i=0;i<size;i++){
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();

        towSumII(numbers, target);

    }
}
