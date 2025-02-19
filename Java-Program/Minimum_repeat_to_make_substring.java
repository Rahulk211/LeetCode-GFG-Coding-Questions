public class Minimum_repeat_to_make_substring {

    private static int minRepeats(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int min_repeat =0;
        int i=0;
        
        while(i<s2.length()){
            if(sb.toString().contains(s2)){
                return min_repeat;
            }
            else{
                min_repeat += 1;
                sb.append(s1);
            }
            i++;
        }

        return -1;
    }
    public static void main(String[] args) {
        String s1 ="ab";
        String s2 = "cab";

        System.out.println(minRepeats(s1,s2));

    }
    
}
