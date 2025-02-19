import java.util.HashMap;
import java.util.Scanner;

//import org.xml.sax.HandlerBase;

public class Nonrepeatingchar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
    
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i)+"")){
                map.put(str.charAt(i)+"",map.get(str.charAt(i)+"")-1);
            }
            else{
                map.put(str.charAt(i)+"",1);
            }
        }

        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i)+"")==1){
                System.out.println(str.charAt(i));
            }   
        }    
    }
}
