package Sorting;
import java.util.Scanner;

public class Quicksort {
    public static void QuickSort(int[] arr, int low,int high){
        if(low<high){
            int mid = Partition(arr,low,high);
            QuickSort(arr, low, mid-1);
            QuickSort(arr,mid+1,high); 
        }
    }
    public static int Partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j =low;j<high;j++){
            if(arr[j]<=pivot){
                i=i+1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high] = temp;

        return i+1;
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
        int n=arr.length-1;
        QuickSort(arr,0,n);
        PrintArr(arr);
    }
}
