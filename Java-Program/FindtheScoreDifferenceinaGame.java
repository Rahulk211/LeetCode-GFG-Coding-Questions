public class FindtheScoreDifferenceinaGame {

    public static int scoreDifference(int[] nums) {
        int ans=0;
        boolean isActive=true;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            if((i+1)%6==0){
                isActive = !isActive;
            }
             if( nums[i]%2!=0){
                isActive = !isActive;
            }
            if(isActive){
                ans+=nums[i];
            }
            else{
                ans-=nums[i];
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {2,4,2,1,2,1};
        System.out.println(scoreDifference(nums));
    }
}
