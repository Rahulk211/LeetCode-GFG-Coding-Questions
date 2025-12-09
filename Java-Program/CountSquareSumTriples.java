public class CountSquareSumTriples {

    private static int countTriples(int n){
        int res = 0;
        for(int u=2;u*u < n; u++){
            for(int v=1;v<u;v++){
                if(((u-v)&1) == 0 || gcd(u,v) != 1){
                    continue;
                }
                int c = u*u + v*v;
                if(c>n){
                    continue;
                }
                res += n/c<<1;
            }
        }
        return res;
    }

    private static int gcd(int x, int y){
        return y==0 ? x : gcd(y, x%y);
    }
    public static void main(String[] args) {
        int n = 18;
        System.out.println(countTriples(n));
    }
}
