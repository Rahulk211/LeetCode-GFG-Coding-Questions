package Sorting;
import java.util.Scanner;

public class Bubblesort {

    public static void BubbleSort(int[] arr){
        int n =arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                int a=j+1;
                if(arr[j]>arr[a]){
                    int temp =arr[j];
                    arr[j] = arr[a];
                    arr[a]=temp;
                }
            }
        }
    }

    public static void PrintArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        int size = sc.nextInt();
        
        int[] arr = new int[size];
        System.out.println("enter the array elements");
        for(int i=0;i<size;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        BubbleSort(arr);
        PrintArr(arr);

    }
}
