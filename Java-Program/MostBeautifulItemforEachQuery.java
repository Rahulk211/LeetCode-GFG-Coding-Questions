import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MostBeautifulItemforEachQuery {

    private static int[] maximumBeauty(int[][] items, int[] queries){
        int n = items.length;
        int m = queries.length;
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        for(int i=0;i<n-1;i++){
            items[i+1][1] = Math.max(items[i][1], items[i+1][1]);
        }
        
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            res[i] = binarySearch(items, queries[i]);
        }

        return res;
    }

    private static int binarySearch(int[][] items, int price){
        int lb=0;
        int ub = items.length-1;
        int beauty=0;
        
        while(lb<=ub){
            int mid = lb+(ub-lb)/2;
            if(items[mid][0]<=price){
                beauty = Math.max(beauty, items[mid][1]);
                lb = mid+1;
            }
            else{
                ub = mid-1;
            }
        }
        return beauty;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print( "Enter number of rows : ");
        int n = sc.nextInt();
        System.out.println("Enter element of items : ");
        int[][] items = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                items[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the size  of queries array : ");
        int m = sc.nextInt();
        int[] queries = new int[m];
        for(int i=0;i<m;i++){
            queries[i] = sc.nextInt();
        }

        sc.close();
        int[] res = maximumBeauty(items, queries);
        for(int i=0;i<m;i++){
            System.out.print(res[i]+" ");
        }

    }
    
}
