package Stack;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterNo {

    public static int[] NextGreatestNumber(int[] nums2){
        Stack<Integer> stk = new Stack<>();
        int[] nge = new int[nums2.length];
        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums2[i]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nge[i]=-1;
            }
            else {
                nge[i] = stk.peek(); 
            }
            stk.push(nums2[i]);
        }

        return nge;
    }

    public static int[] FindNextGreaterElement(int[] nums1 , int[] nums2){
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n =nums2.length;
        for(int i=n-1;i>=0;i--){
            int num = nums2[i];
            while(!stk.isEmpty() && stk.peek()<=num){
                stk.pop();
            }
            if(stk.isEmpty()){
                map.put(num,-1);
            }
            else {
                map.put(num,stk.peek());
            }
            stk.push(num);
        }
        int[] nge=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            nge[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]):-1;
        }
        return nge;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of array 1: ");
        int n1=sc.nextInt();
        int[] nums1=new int[n1];
        System.out.print("\nenter the size of array 2: ");
        int n2=sc.nextInt();
        int[] nums2=new int[n2];
        System.out.println("enter the element of first arrray :");
        for(int i=0;i<n1;i++){
            nums1[i] = sc.nextInt();
        }
        System.out.println("enter the element of second arrray :");
        for(int i=0;i<n2;i++){
            nums2[i] = sc.nextInt();
        }
        sc.close();

        int[] nge = NextGreatestNumber(nums2);
        int[] nfe = FindNextGreaterElement(nums1, nums2);
        for(int i=0;i<nge.length;i++){
            System.out.print(nge[i]+" ");
        }
        System.out.println();
        for(int i=0;i<nfe.length;i++){
            System.out.print(nfe[i]+" ");
        }
    }
}
