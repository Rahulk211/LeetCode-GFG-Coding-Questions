import java.util.ArrayList;
import java.util.List;

public class CheckifOneStringSwapCanMakeStringsEqual {

    private static boolean areAlmostEqual(String s1, String s2){
        if(s1.equals(s2)) return true;
        List<Character> list = new ArrayList<>();
        int mismatch=0;
        int j=0;
        while(j<s1.length()){
            if(s1.charAt(j) != s2.charAt(j)){
                mismatch+=1;
                list.add(s1.charAt(j));
                list.add(s2.charAt(j));
            }
            if(mismatch>2){
                return false;
            }
            j++;
        }
        
        if(list.size() == 4){
            return(list.get(0) == list.get(3) && list.get(1) == list.get(2));
        }
        else{
            return false;
        } 

    }
    public static void main(String[] args) {
        String s1 = "attack";
        String s2 = "defend";
        System.out.println(areAlmostEqual(s1,s2));
    }
}
