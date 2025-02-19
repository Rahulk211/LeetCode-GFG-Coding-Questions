import java.util.Scanner;

public class LeetcodeCandy {

    public static int candy(int[] rating){
        //int mincandy=0;
        int n= rating.length;
        // here tc =O(2n);
        // sc = O(2n);
        // int[] left = new int[rating.length];
        // int[] right = new int[rating.length];
        // left[0]=1;
        // right[n-1] = 1;
        // for(int i =1;i<n;i++){
        //     if(rating[i]>rating[i-1]){
        //         left[i] = left[i-1]+1;
        //     }
        //     else{
        //         left[i] = 1;
        //     }
        //     //System.out.println(left[i]);
        // }

        // for(int i = n-2;i<=0;i--){
        //     if(rating[i]>rating[i+1]){
        //         right[i] = right[i+1]+1;
        //     }
        //     else{
        //         right[i] = 1;
        //     }
        //     //System.out.println(right[i]);
        // }

        // for(int i = 0;i<n;i++){
        //     mincandy += Math.max(left[i],right[i]);
        // }

        int[] left = new int[n];
        int right = 1;
        int curr = 1;
        left[0]=1;
        for(int i =1;i<n;i++){
            if(rating[i]>rating[i-1]){
                left[i] = left[i-1]+1;
            }
            else{
                left[i] = 1;
            }
                
        }

        int mincandy = Math.max(1,left[n-1]); 
        for(int i=n-2;i<=0;i--){
            if(rating[i]>rating[i+1]){
                curr = right+1;
                right = curr;
            }
            else{
                curr=1;
            }
            mincandy += Math.max(left[i],curr); 
        }

        return mincandy;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size= sc.nextInt();
        int[] rating = new int[size];
        for(int i=0;i<size;i++){
            rating[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(candy(rating));
    }
    
}
