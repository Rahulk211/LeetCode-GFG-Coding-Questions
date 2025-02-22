package Sorting;
import java.util.Scanner;

public class Insertionsort{

    public static void InsertionSort(int[] arr){
        int n = arr.length;

        for(int i=1;i<n;i++){
            int key = arr[i];
            // int j =i-1;
            // while(j>=0 && arr[j]>key){
            //     arr[j+1] = arr[j];
            //     j=j-1;
            // }
            int j;
            for( j =i-1;j>=0 && arr[j]>key;j--){
                arr[j+1] = arr[j];
            }
            arr[j+1]=key;
        }
    }

    public static void PrintArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        InsertionSort(arr);
        PrintArr(arr);
        sc.close();
    }
}