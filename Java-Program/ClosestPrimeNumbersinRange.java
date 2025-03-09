import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestPrimeNumbersinRange {


    private static int[] closestPrimes(int left, int right){
        boolean[] isPrime = new boolean[right+1];
        Arrays.fill(isPrime, true);
        for(int i=2;i*i<=right;i++){
            if(isPrime[i] == true){
                for(int j=2;j*i<=right;j++){
                    isPrime[i*j]=false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for(int i=Math.max(2,left);i<=right;i++){
            if(isPrime[i]==true){
                primes.add(i);
            }
        }

        int a = 0;
        int b = Integer.MAX_VALUE;
        for(int i=1;i<primes.size();i++){
            if((b-a )> primes.get(i)-primes.get(i-1)){
                a = primes.get(i-1);
                b = primes.get(i);
            }
        }

        if(a==0) return new int[] {-1,-1};
        return new int[] {a,b};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        sc.close();
        int[] res = closestPrimes(left, right);
        System.out.println(res[0] + " " + res[1]);
    }
}
