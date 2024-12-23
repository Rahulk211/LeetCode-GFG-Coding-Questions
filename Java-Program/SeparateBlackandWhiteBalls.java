import java.util.Scanner;

public class SeparateBlackandWhiteBalls {

    private static int minimumSteps(String s){
        int opt = 0;
        int last =0;
        for(int cur = 0;cur<s.length();cur++){
            if(s.charAt(cur)=='1'){
                continue;
            }else{
                opt += (cur-last);
                last++;
            }
        }
        return opt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        sc.close();
        System.out.println("the minimum number of steps are : "+ minimumSteps(s));

    }
}
