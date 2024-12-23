import java.util.Arrays;
import java.util.Scanner;

public class FindLongestSpecialSubstringThatOccursThrice_I {

    static int getMinimum(int row,int[][] tp3freq){
        int[] arr = tp3freq[row];
        if (arr[0] == -1 && arr[1] == -1 && arr[2] == -1) return 0;
        if(arr[0]<=arr[1] && arr[0]<=arr[2])  return 0;
        if(arr[1]<=arr[0] && arr[1]<=arr[2])  return 1;
        return 2;
    }

    private static int maximumLength(String s){
        // int n = s.length();
        int[][] tp3freq = new int[26][3];
        for (int i = 0; i < tp3freq.length; i++) {
            Arrays.fill(tp3freq[i], -1);
        }
        char last_seen = '*';
        int winlen = 0;
        for(char c : s.toCharArray()){
            int idx = c-'a';
            winlen = (c==last_seen)?winlen+1:1;
            last_seen = c;
            int col = getMinimum(idx, tp3freq);
            if(tp3freq[idx][col]<winlen){
                tp3freq[idx][col] = winlen;
            }
        }
        int maxlen = -1;
        for(int[] arr : tp3freq){
            maxlen = Math.max(maxlen,Math.min(arr[0],Math.min(arr[1],arr[2])));
        }
        return maxlen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        String s = sc.next();
        sc.close();
        System.out.println(maximumLength(s));
    }
    
}
