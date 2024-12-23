package Stack;
//Stack implementation using Array.

import java.util.Scanner;

public class StkImps {
    public static int top = -1;
    public static int size = 0;
    public static int[] stk;

    public static void Push(Scanner sc){
        if(top == size-1){
            System.out.println("stack overflow");
            return;
        }
        System.out.println("Enter data");
        int data =sc.nextInt();
        top=top+1;
        stk[top]=data;
    }

    public static void Pop(){
        if(top == -1){
            System.out.println("stack underflow");
            return;
        }
        System.out.println("popped element is "+stk[top]);
        top=top-1;
    }

    public static int top(){
        if(top==-1){
            //System.out.println("stack is empty");
            return -1;
        }
        return stk[top];
    }

    public static int size(){
        return (top+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the stack");
        size = sc.nextInt();
        stk = new int[size];
        int choice=0;
        do{
            System.out.println("1. Push\n");
            System.out.println("2. Pop\n");
            System.out.println("3. Top\n");
            System.out.println("4. Size\n");
            System.out.println("0. Exit\n");

            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Push(sc);
                    break;
                case 2:
                    Pop();
                    break;
                case 3:
                    System.out.println(top());
                    break;
                case 4:
                    System.out.println(size());
                    break;
                case 0:
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    break;
            }
        }while(choice!=0);
        sc.close();
    }
}
