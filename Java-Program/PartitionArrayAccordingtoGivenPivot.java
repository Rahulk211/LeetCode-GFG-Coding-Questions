import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartitionArrayAccordingtoGivenPivot {

    private static int[] pivotArray(int[] nums, int pivote){
        int n=nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<pivote){
                list1.add(nums[i]);
            }
            else if(nums[i]>pivote){
                list2.add(nums[i]);
            }
            else{
                list3.add(nums[i]);
            }
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(i<list1.size()){
                result[i]=list1.get(i);
            }
            else if(i<list1.size()+list3.size()){
                result[i]=list3.get(i-list1.size());
            }
            else{
                result[i]=list2.get(i-list1.size()-list3.size());
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();         //nums = [9,12,5,10,14,3,10], pivot = 10
        }
        int pivote= sc.nextInt();
        sc.close();
        int[] result = pivotArray(nums, pivote);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
