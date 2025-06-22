import java.util.Scanner;

public class DivideaStringIntoGroupsofSizek {

    private static String[]  divideStrings(String s, int k, char fill){
        int n = s.length();
        int size = (n+k-1)/k;

        String[] result = new String[size];
        for(int i=0;i<size;i++){
            int start = i * k;
            int end = Math.min(start + k, n);
            StringBuilder sb = new StringBuilder();

            for(int j=start; j<end; j++){
                sb.append(s.charAt(j));
            }

            while(sb.length() < k){
                sb.append(fill);
            }

            result[i] = sb.toString();
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        char fill = sc.next().charAt(0);
        sc.close();

        String[] res = divideStrings(s, k, fill);
        for(String str : res) {
            System.out.println(str);
        }
    }
}
