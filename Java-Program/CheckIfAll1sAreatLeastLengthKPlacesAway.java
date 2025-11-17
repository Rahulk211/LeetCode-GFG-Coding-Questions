public class CheckIfAll1sAreatLeastLengthKPlacesAway {

    private static boolean kLengthApart(int[] nums, int k){
        int n = nums.length;
        int lastOneIndex = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                if(lastOneIndex != -1 && i - lastOneIndex - 1 < k){
                    return false;
                }
                lastOneIndex = i;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k = 2;
        System.out.println(kLengthApart(nums, k)); // Output: true
    }
    
}
