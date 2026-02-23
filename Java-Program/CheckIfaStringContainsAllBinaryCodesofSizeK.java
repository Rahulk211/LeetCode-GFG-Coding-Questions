public class CheckIfaStringContainsAllBinaryCodesofSizeK {

    private static boolean hasAllCodes(String s, int k){
        // int  j=0;
        // Set<String> set = new HashSet<>();
        // StringBuilder sb = new StringBuilder();
        // while(j<s.length()){
        //     sb.append(s.charAt(j));

        //     if(sb.length() > k ){
        //         sb.deleteCharAt(0);
        //     }
        //     if(sb.length()==k){
        //         set.add(sb.toString());
        //     }
        //     j++;
        // }

        // return set.size() == Math.pow(2,k);

        int need = 1<<k;
        int msk = need - 1;
        int hsh = 0;
        int cnt=0;
        boolean[] seen = new boolean[need];

        for(int i=0;i<s.length();i++){
            hsh = ((hsh << 1) & msk) | (s.charAt(i)-'0');
            
            if(i>=k-1){
                if(!seen[hsh]){
                    seen[hsh] = true;
                    cnt++;
                    if(cnt == need) return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String s = "00110110";
        int k=2;

        System.out.println(hasAllCodes(s, k));
    }
}
