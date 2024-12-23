import java.util.Scanner;

public class SpecialArray_II {

    // static boolean isSpecial(int start,int end, int[] nums){
    //     boolean[] vis = new boolean[end-start+1];
    //     int i=0;
    //     while(start<=end){
    //         if(nums[start]%2==0){
    //             vis[i]=true;
    //         }
    //         else  vis[i]=false;
    //         start++;
    //         i++;
    //     }
        
    //     if(vis.length==1){
    //         return true;
    //     }
    //     for(int j=0;j<vis.length-1;j++){
    //         if(vis[j]==vis[j+1]){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    private static boolean[]  isArraySpecial(int[] nums,int[][] queries){
        int n = nums.length;
        boolean[] answer = new boolean[queries.length];
        // int i=0;
        // for(int[] num : queries){
        //     int start = num[0]; 
        //     int end = num[1];
        //     res[i] = isSpecial(start, end, nums);
        //     i++;
        // }
        // return res;

        int[] parity = new int[n];
        for(int i=0;i<n;i++){
            parity[i] = nums[i]%2;
        }

        for(int i=0;i<queries.length;i++){
            int s = queries[i][0];
            int ed = queries[i][1];
            
            boolean isSpecial = true;

            for(int j=s;j<ed;j++){
                if(parity[j]==parity[j+1]){
                    isSpecial = false;
                    break;
                }
            }
            answer[i] = isSpecial;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the length of 2d array : ");
        int m = sc.nextInt();
        int[][] queries = new int[m][2];
        System.out.println("Enter the element of nums array : ");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Enter the element of queries array : ");
        for(int i=0;i<m;i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sc.close();

        boolean[] res =  isArraySpecial(nums, queries);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
