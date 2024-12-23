

public class ShortestSubarrayWithORatLeastKII {

    private static int shortestSubarray(int[] nums, int k){
        // int or =0;
        // int len =0;
        // int min = Integer.MAX_VALUE;
        // for(int num : nums){
        //     or |= num;
        //     len++;
        //     //System.out.println(or);
        //     if(or >= k){
        //         //System.out.println(len);
        //         min = Math.min(len, min);
        //         or =0;
        //         len=0;
        //     }
        // }
        // return min;
        int or = 0;
        int[] bit_count = new int[32];
        int min = Integer.MAX_VALUE;
        int i=0,j=0;
        
        while(j<nums.length){
            // or |= nums[j];
            or = performOperation(or, bit_count,nums[j]);

            while(i<=j && or >= k){
                min = Math.min(min, j-i+1);
                or = reverseOperation(or, bit_count, nums[i]);
               
                i++;
            }
            j++;
        }

        return (min==Integer.MAX_VALUE) ? -1:min;
    }

    static int performOperation(int or, int[] bit_count, int num){
        or = or|num;

        for(int i=0;i<32;i++){
            if((num & (1 << i) )!= 0){
                bit_count[i]++;
            }
        }

        return or;
    }

    static int reverseOperation(int or, int[] bit_count, int num){

        for(int i=0;i<32;i++){
            if((num & (1<<i))!=0){
                bit_count[i] -= 1;
            }

            if(bit_count[i] == 0){
                or = or & (~(1<<i));
            }
        }

        return or;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2,32,21};
        int k = 55;
        System.out.println("ans : "+shortestSubarray(arr, k));
    }
    
}
