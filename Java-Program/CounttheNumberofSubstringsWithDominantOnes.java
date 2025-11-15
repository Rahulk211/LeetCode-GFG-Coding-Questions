import java.util.Scanner;

public class CounttheNumberofSubstringsWithDominantOnes{

    private static int numberOfSubstrings(String s){
        int n = s.length();
        int[] left = new int[n+1];
        left[0]=-1;
        for(int i=0;i<n;i++){
            if(i==0 || s.charAt(i-1) == '0'){
                left[i+1] = i;
            }else{
                left[i+1] = left[i];
            }
        }

        int ans = 0;
        for(int i=1;i<=n;i++){
            int cnt0 = 0;
            if(s.charAt(i-1) == '0') cnt0 = 1;
            int j=i;

            while(j>0 && (cnt0*cnt0)<=n){
                int cnt1 = (i-left[j])-cnt0;
                if(cnt1 >= cnt0*cnt0){
                    ans += Math.min(j-left[j],cnt1 - (cnt0*cnt0)+1);
                }

                j = left[j];
                cnt0+=1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        System.out.println(numberOfSubstrings(s));
    }
}