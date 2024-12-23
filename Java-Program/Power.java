public class Power {

    public static double myPow(double x,int n){
        if(n==0) return 1;
        double half = myPow(x,n/2);
        if(n%2==0) return half*half;
        
        return x*half*half;
    }
    public static void main(String[] args) {
        double x=2;
        int n=10;
        System.out.println(myPow(x,n));
    }
}
