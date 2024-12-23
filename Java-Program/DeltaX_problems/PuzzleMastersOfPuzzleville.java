package DeltaX_problems;

//import java.util.Arrays;
import java.util.Scanner;

public class PuzzleMastersOfPuzzleville {

    public static int puzzleMasters(int index, int k, int[] pieces){
        if(k==0){
            return 1;
        }
        if(index>=pieces.length || k<0){
            return 0;
        }
        int include = puzzleMasters(index+1,k-pieces[index],pieces);
        int exlude = puzzleMasters(index+1, k, pieces);

        return (include+exlude)-2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] pieces = new int[n];
        for(int i=0;i<n;i++){
            pieces[i] = sc.nextInt();
        }
        sc.close();

        int noCombinations = puzzleMasters(0,k,pieces);
        System.out.println(noCombinations);
    }

    
}
