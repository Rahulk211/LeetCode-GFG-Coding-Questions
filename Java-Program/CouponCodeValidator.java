import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CouponCodeValidator{

    private static boolean is_Active(boolean status){
        return status;
    }

    private static boolean is_ValidCode(String code){
        return code != null && !code.isEmpty() && code.matches("^[a-zA-Z0-9_]+$") ;     //"electronics", "grocery", "pharmacy", "restaurant"
    }
    private static boolean isValidBussiness(String bussinessLine){
        return bussinessLine != null && !bussinessLine.isEmpty() && (bussinessLine.equals("electronics") || bussinessLine.equals("grocery") || bussinessLine.equals("pharmacy") || bussinessLine.equals("restaurant"));
    }

    private static List<String> validateCoupons(String[] code, String[] bussinessLine, boolean[] isActive){
        int n = code.length;
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new TreeMap<>((a,b) -> {
            return a.compareTo(b);
        });

        for(int i=0;i<n;i++){
            if(is_Active(isActive[i]) && is_ValidCode(code[i]) && isValidBussiness(bussinessLine[i])){
                map.computeIfAbsent(bussinessLine[i],k -> new ArrayList<>()).add(code[i]);
            }
        }

        for(List<String> codes : map.values()){
            Collections.sort(codes);
        }

        for(List<String> codes : map.values()){
            result.addAll(codes);
        }

        return result;
    }
    public static void main(String[] args) {
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] bussinessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,false,true,true};

        List<String> res = validateCoupons(code, bussinessLine, isActive);
        System.out.println(res);
    }
}