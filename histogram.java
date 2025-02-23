public class histogram{
    public static void main(String[] args) {
        int n=5;
        int[] data = {3,5,2,7,4};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(data[j]==0){
                    System.out.print(" ");
                    continue;
                }
                data[j] = data[j]-1;
                System.out.print("*");
            }
            System.out.println();
        }
    }
}