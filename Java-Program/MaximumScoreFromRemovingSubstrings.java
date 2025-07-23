import java.util.Scanner;

public class MaximumScoreFromRemovingSubstrings {

    private static int maximumGain(String s, int x, int y){
        int score = 0;
        // while(s.contains("ab") || s.contains("ba")){
        //     if(s.contains("ab") && s.contains("ba")){
        //         if(x > y){
        //             score += x;
        //             s = s.replaceFirst("ab", "");
        //         } else {
        //             score += y;
        //             s = s.replaceFirst("ba", "");
        //         }

        //     } else if(s.contains("ab") && !s.contains("ba")){
        //         score += x;
        //         s = s.replaceFirst("ab", "");
        //     }
        //     else if(s.contains("ba") && !s.contains("ab")){
        //         score += y;
        //         s = s.replaceFirst("ba", "");
        //     }
        // }
        // return score;

        if(y>x){
            int temp = x;
            x=y;
            y=temp;
            s = new StringBuilder(s).reverse().toString();
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            sb.append(c);
            int len = sb.length();
            if(len >=2 && sb.charAt(len - 2) == 'a' && sb.charAt(len - 1) == 'b'){
                sb.delete(len-2, len);
                score+=x;
            }
        }

        s = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for(char c : s.toCharArray()){
            sb2.append(c);
            int len = sb2.length();
            if(len >=2 && sb2.charAt(len - 2) == 'b' && sb2.charAt(len - 1) == 'a'){
                sb2.delete(len-2, len);
                score+=y;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.close();
        System.out.println(maximumGain(s, x, y));
    }
}
