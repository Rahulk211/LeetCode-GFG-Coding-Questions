import java.util.Scanner;

public class NumberofPeopleAwareofaSecret {

    static int mod = (int)1e9+7;

    private static int peopleAwareOfSecret(int n, int delay, int forget){
        long[] dp = new long[n+1];
        dp[1] = 1;
        long shares = 0;

        for(int i=2;i<=n;i++){
            if(i-delay>=1){
                shares = (shares+dp[i-delay]) % mod;
            }
            if(i-forget>=1){
                shares = (shares-dp[i-forget] + mod) %mod;
            }
            dp[i] =  shares;
        }

        long ans =0;

        for(int i=n-forget+1;i<=n;i++){
            if(i>=1){
                ans =(ans+dp[i])%mod;
            }
        }

        return (int) ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int delay=sc.nextInt();
        int forget=sc.nextInt();

        sc.close();

        System.out.println(peopleAwareOfSecret(n,delay,forget));
    }
}
