package Stack;
import java.util.Scanner;

public class SimplifyPath {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        String st = sc.next();
        String[] arr = st.split("/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("..")) {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            else if(!arr[i].equals("") && !arr[i].equals(".") && !arr[i].equals("/")) {
                sb.append("/").append(arr[i]);
            }
        }
        System.out.println(sb);
        sc.close();

    }
}
