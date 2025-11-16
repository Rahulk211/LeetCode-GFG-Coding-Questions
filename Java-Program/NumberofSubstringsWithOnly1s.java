public class NumberofSubstringsWithOnly1s {

    static int mod = 1000000007;

    private static int numSub(String s){
        int n = s.length();
        int ans = 0;
        int cnt = 0;
        
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                cnt++;
            }
            else{
                ans += (cnt+1)*cnt/2 % mod;
                cnt = 0;
            }

        }
        ans += (cnt+1)*cnt/2 % mod;
        return ans;
    }
    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(numSub(s));
    }
}
