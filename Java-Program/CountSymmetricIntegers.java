import java.util.Scanner;

public class CountSymmetricIntegers {
    private static int countSymmetricIntegers(int low, int high){
        int cnt =0;
        for(int i=low;i<=high;i++){
            if((i>=10 && i<=99) && (i%11==0)){
                cnt++;
            }
            else if((i>=1000 && i<=9999)){
                int a = i/1000;
                int b = (i/100)%10;
                int c = (i/10)%10;
                int d = i%10;

                if((a+b) == (c+d)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        sc.close();

        System.out.println(countSymmetricIntegers(low, high));
    }
}
