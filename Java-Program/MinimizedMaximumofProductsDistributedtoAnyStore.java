//import java.util.Arrays;
import java.util.Scanner;

public class MinimizedMaximumofProductsDistributedtoAnyStore {

    private static int minimizedMaximum(int n, int[] quantities){
        // Arrays.sort(quantities);

        // return BinarySearch(quantities, n, 1, quantities[quantities.length-1]);
        //int m = quantities.length;
        int l = 1;
        int h = 100000;
        int ans = Integer.MAX_VALUE;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(canAssign(quantities,mid,n)){
                ans = Math.min(ans,mid);
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    private static boolean canAssign(int[] q,int mid, int n){
        int cnt = 0;
        for(int i=0;i<q.length;i++){
            cnt+=Math.ceil((double)q[i]/mid);
        }   
        return cnt<=n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of stores : ");
        int n = sc.nextInt();
        System.out.print("\n Enter the number of products : ");
        int m = sc.nextInt();
        int[] quantities = new int[m];
        System.out.println("Enter the product quantities : ");
        for(int i=0;i<m;i++){
            quantities[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Minimize maximum distribution is : "+minimizedMaximum(n, quantities));
    }
    
}
