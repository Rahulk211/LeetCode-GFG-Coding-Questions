import java.util.ArrayList;
//import java.util.Scanner;

public class KSizedSubarrayMaximum {

    public static ArrayList<Integer> max_of_subarrays(int k, int arr[]){
        if(arr.length == 0 ){
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        int i=0,j=0;
        int n = arr.length;
        int max_ele = 0;

        while(j<n){
            max_ele = Math.max(max_ele,arr[j]);
            if(j-i+1==k){
                res.add(max_ele);  
                if(max_ele == arr[i]){
                    max_ele = Integer.MIN_VALUE;
                    for(int idx = i+1; idx <= j; idx++){
                        max_ele = Math.max(max_ele, arr[idx]);
                    }
                }
                i++;
            }
            j++;
        }

        return res;
    }
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // int[] arr = new int[n];

        // for(int i=0;i<n;i++){
        //     arr[i] = s.nextInt();
        // }

        // int k = s.nextInt();
        // s.close();
        int[] arr = {83 ,13, 23, 82, 20, 4, 83, 96, 88, 50, 93, 35, 5, 33, 25, 2, 93, 96, 32, 68, 17, 99, 60, 33, 14, 43, 84, 56, 38, 46, 67, 69, 47, 6, 32, 31, 71, 38, 89, 63, 31, 25, 72, 10};
        int k =9;

        ArrayList<Integer> res = max_of_subarrays(k, arr);
        System.out.println("the list of max element in array is : " + res);
    }
}
