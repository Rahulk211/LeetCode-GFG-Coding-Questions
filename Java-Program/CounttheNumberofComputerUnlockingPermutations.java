public class CounttheNumberofComputerUnlockingPermutations {

    private static int countPermutations(int[] comp){
        int n = comp.length;
        int first = comp[0];
        int mod = 1000_000_007;

        for(int i=1;i<n;i++){
            if(comp[i] <= first) return 0;
        }

        long fact = 1;
        for(int i=2;i<n;i++){
            fact = (fact * i) %mod;
        }
        
        return (int) fact;
    }
    public static void main(String[] args) {
        int[] complexity = {3,3,3,4,4,4};

        System.out.println(countPermutations(complexity));
    }
}
