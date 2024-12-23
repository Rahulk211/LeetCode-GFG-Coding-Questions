import java.util.Scanner;
public class addarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[5];
        int[] arr2= new int[5];
        System.out.println("Enter the element in the array");
        for(int i=0;i<5;i++){
            arr1[i]=sc.nextInt();

        }
        System.out.println("Enter the element in the array2");
        for(int i=0;i<5;i++){
            arr2[i]=sc.nextInt();
            
        }
        int[] sum= new int [5];
        for(int j=0;j<5;j++){
            sum[j]=arr1[j]+arr2[j];
        }
        System.out.println("new array");
        for(int j=0;j<5;j++){
            System.out.println(sum[j]);
        }
        sc.close();
    }
    
}
