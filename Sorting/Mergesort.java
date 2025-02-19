package Sorting;
import java.util.Scanner;

public class Mergesort {

    public static void MergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            MergeSort(arr, low, mid);
            MergeSort(arr,mid+1,high);
            Merge(arr,low,mid,high);
        }
    }
    public static void Merge(int[] arr ,int l,int m,int h){
        
        int n1=m-l+1;
        int n2=h-m;

        int[] left = new int[n1+1];
        int[] right = new int[n2+1];

        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }

        for(int i=0;i<n2;i++){
            right[i]=arr[m+i+1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
        int i=0,j=0;
        for(int k=l;k<=h;k++){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
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
        int n=arr.length-1;
        MergeSort(arr,0,n);
        PrintArr(arr);
    }
}
