import java.util.Scanner;

public class LongestHappyString {

    private static String longestDiverseString(int a,int b, int c){
        StringBuilder sb = new StringBuilder();
        int maxlen = a+b+c;
        int ca=0,cb =0,cc =0;
        for(int i=0;i<maxlen;i++){
            if((a>=b && a>=c && ca!=2) || (cb==2 && a>0) || (cc==2 && a>0)){
                sb.append('a');
                a-=1;
                ca+=1;
                cb=0;
                cc=0;
            }
            else if((b>=a && b>=c && cb!=2) || (ca==2 && b>0) || (cc==2 && b>0)){
                sb.append('b');
                b-=1;
                cb+=1;
                ca=0;
                cc=0;
            }
            else if(cc!=2 && c>0){
                sb.append('c');
                c-=1;
                cc+=1;
                ca=0;
                cb=0;
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a,b, and c");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        System.out.println("the longest posible string is : " + longestDiverseString(a,b,c));
    }
    
}
