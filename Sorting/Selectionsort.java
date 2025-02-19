package Sorting;
import java.util.Scanner;

public class Selectionsort {
    public static void SelectionSort(int[] arr){
        int n =arr.length;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
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

    SelectionSort(arr);
    PrintArr(arr);
   } 
}
