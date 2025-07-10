import java.util.ArrayList;
import java.util.Arrays;

public class Countingelementsintwoarrays {

    private static int findNum(int[] b, int n, int target){
        int high = n-1;
        int low = 0;
        
        while(low<=high){
            int mid = low+(high-low) / 2;
            if(b[mid] <= target){
                low = mid+1;
            }
            else if( b[mid] > target){
                high = mid-1;
            }
            
        }

        return low;
    }

    private static ArrayList<Integer> countLessEq(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(b);
        for(int i=0;i<m;i++){
            int idx = findNum(b, n, a[i]);
            res.add(idx);
        }

        return res;
    }
    public static void main(String[] args) {
        int[] a = {10, 20};
        int[] b = {40, 48, 30};

        System.out.println(countLessEq(a,b));
    }
}
