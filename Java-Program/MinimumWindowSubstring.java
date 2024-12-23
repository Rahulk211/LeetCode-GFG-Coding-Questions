public class MinimumWindowSubstring {

    public static String minWinSubstring(String s,String t){
        int minlen = Integer.MAX_VALUE;
        int n=s.length();
        int m=t.length();
        int sindex=-1;
        int cnt=0;
        int[] hash = new int[255];
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }
        int r=0,l=0;
        while(r<n){
            if(hash[s.charAt(r)]>0){
                cnt+=1;
            }
            hash[s.charAt(r)]--;
            while(cnt==m){
                if(r-l+1<minlen){
                    minlen=r-l+1;
                    sindex=l;
                }
                
                if(hash[s.charAt(l)]>0){
                    cnt-=1;
                    hash[s.charAt(l)]++;
                }
            }
            r=r+1;
        }
        
        return sindex==-1? "" : s.substring(sindex, minlen);
    }
    public static void main(String[] args) {
        String s = "ddaaabbac";
        String t = "abc";
        String sb = minWinSubstring(s, t);
        System.out.println(sb);
    }
    
}
