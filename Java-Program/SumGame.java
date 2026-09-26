import java.util.Scanner;

public class SumGame{

    private static boolean sumGame(String num){
        int n = num.length();
        int mid = n/2;
        String lf = num.substring(0, mid);
        String rf = num.substring(mid,n);
        
        int sl = 0, sr = 0, ql = 0, qr = 0; 

        for(int i=0;i<lf.length();i++){
            if(lf.charAt(i)=='?'){
                ql++;
            }
            else{
                sl+=lf.charAt(i)-'0';
            }
        }

        for(int i=0;i<lf.length();i++){
            if(rf.charAt(i)=='?'){
                qr++;
            }
            else{
                sr+=rf.charAt(i)-'0';
            }
        }

        if((qr+ql)%2!=0){
            return true;
        }

        else{
            int diff = sl-sr;
            double target = ql-qr/2*9;

            if(diff == target){
                return false;
            }
            else return true;
        }



    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your string of even length: - ");
        String num = sc.next();
        sc.close();

        System.out.println(sumGame(num));
    }
}