public class bitand2_bitCharacters {

    private static boolean isOneBitCharacter(int[] bits){
        int n =bits.length;
        if(n==1) return bits[0] == 0 ? true : false;

        int i=0;
        while(i<n-1){
            i += bits[i]+1;
        }

        return i==n-1 ? true:false;

    }
    public static void main(String[] args) {
        int[] bits = {1,1,0};

        System.out.println(isOneBitCharacter(bits));
    }
}
