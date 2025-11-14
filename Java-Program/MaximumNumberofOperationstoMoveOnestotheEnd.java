public class MaximumNumberofOperationstoMoveOnestotheEnd {

    private static int maximumOperations(String s){
        int n = s.length();
        int ops = 0;
        int cnt=0; 
        int i=0;

        while(i<n){
            if(s.charAt(i)=='1'){
                cnt++;
            }
            else{
                int j=i+1;
                while(j<n && s.charAt(j)=='0'){
                    j++;
                }
                ops+= cnt;
                i=j-1;
            }
            i++;
        }
        return ops;
    }
    public static void main(String[] args) {
        String s = "00111";
        System.out.println(maximumOperations(s));
    }
}
