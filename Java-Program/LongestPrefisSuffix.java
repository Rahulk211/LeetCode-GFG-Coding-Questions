public class LongestPrefisSuffix {

    private static int findLPS(String str){
        int i=0,j=1;
        int n = str.length();
        int[] lps = new int[n];

        while(j<n){
            if(str.charAt(i)==str.charAt(j)){
                lps[j++] = ++i;
            }
            else{
                if(i>0){
                    i = lps[i-1];
                }
                else{
                    j++;
                }
            }
        }
        return lps[n-1];
    }
    public static void main(String[] args) {
        String str = "aaa";
        int lps = findLPS(str);
        System.out.println("the longest common prefix and suffix is "+lps);
    }
}
