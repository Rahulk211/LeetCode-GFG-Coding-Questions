public class ClearDigits {

    private static String clearDigits(String s){
        //int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c>='0' && c<='9'){
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                //System.out.println(c);
                sb.append(c);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "cb34";
        System.out.println(clearDigits(s));
    }
}
