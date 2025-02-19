import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class ReorganizeTheArray {

    private static List<Integer> rearrange(List<Integer> nums){
        // for(int i=0;i<nums.size();i++){
        //     if(nums.contains(i)){
        //         result.add(i,i);
        //     }
        //     else{
        //         result.add(i,-1);
        //     }
        // }
        // return result;


        // List<Integer> res = new ArrayList<>(Collections.nCopies(nums.size(), -1));
        // System.out.println(res.size());
        // for(int i=0;i<nums.size();i++){
        //     if(nums.get(i)==-1){
        //         continue;
        //     }
        //     else{
        //         res.add(nums.get(i), nums.get(i));
        //     }
        // }
        // return res;

        int n = nums.size();
        for(int i=0;i<n;i++){
            int correct = nums.get(i);
            if(correct != -1 && nums.get(i)!=nums.get(correct)){
                nums.set(i,nums.get(correct));
                nums.set(correct,correct);
            } 
        }
        return nums;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size of list");
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(sc.nextInt());     //[-1, -1, 6, 1, 9, 3, 2, -1, 4, -1]  op [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
        }
        sc.close();

        System.out.println(rearrange(nums));
    }
}
