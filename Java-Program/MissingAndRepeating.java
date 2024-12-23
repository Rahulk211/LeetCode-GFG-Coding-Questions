public class MissingAndRepeating {

    private static int[] findTwoElement(int[] arr){
        int[] freq = new int[arr.length+1];
        for(int val : arr){
            freq[val]++ ;
        }
        
        
        int rept=0;
        int mis=0;
        for(int i =1;i<freq.length;i++){
            if(freq[i] >= 2){
                rept = i;
            }
            if(freq[i] == 0){
                mis = i;
            }
        }
        
        return new int[]{rept,mis};


    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 5};
        int[] result = findTwoElement(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
