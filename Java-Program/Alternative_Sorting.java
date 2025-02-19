import java.util.ArrayList;
import java.util.Arrays;

public class Alternative_Sorting {

    private static ArrayList<Integer> alternateSort(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int n =arr.length;
        Arrays.sort(arr);
        int i=0,j=n-1;
        while(i<j){
            list.add(arr[j]);
            list.add(arr[i]);
            i++;
            j--;
        }
        if (i == j) {
            list.add(arr[i]);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1, 6, 9, 4, 3, 7, 8, 2};
        System.out.println(alternateSort(arr));
    }
}
