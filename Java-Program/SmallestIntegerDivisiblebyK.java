public class SmallestIntegerDivisiblebyK {

    private static int smallestRepunitDivByK(int k){
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int rem =0;
        int len = 0;
        for(int i=0;i<k;i++){
            rem = (rem*10 + 1)%k;
            len += 1;

            if(rem == 0) return len;
        }
        return -1;
    }
    public static void main(String[] args) {
        int k = 3;
        System.out.println(smallestRepunitDivByK(k));
    }
}
