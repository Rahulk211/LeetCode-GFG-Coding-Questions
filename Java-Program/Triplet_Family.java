import java.util.Arrays;

public class Triplet_Family {

    private static boolean findTriplet(int[] arr){
        Arrays.sort(arr);
        // Set<Integer> set = new HashSet<>();
        // for(int i=0;i<arr.length;i++){
        //     set.add(arr[i]);
        // }
        // for(int i=0;i<arr.length-1;i++){
        //     if(set.contains(arr[i]+arr[i+1])){
        //         return true;
        //     }
        // }
        for(int i=arr.length-1;i>=0;i--){
            int j=0;
            int k=i-1;
            while(j<k){
                if(arr[j]+arr[k]==arr[i]){
                    return true;
                }
                else if(arr[j] + arr[k] > arr[i]){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 6865, 8921, 22468, 20392, 27390, 31530, 8847, 26964, 20505, 21692, 7535 ,
            31540, 18233, 19549, 30152, 12717, 28032, 25526, 23414, 7868, 26691, 22744, 
            18960, 28208, 6250 ,7192, 30569, 10775 ,7450, 22557, 2909};

        System.out.println(findTriplet(arr));
    }
    
}
