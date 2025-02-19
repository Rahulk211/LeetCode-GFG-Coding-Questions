package Queue;

//Queue implementation using Array.

import java.util.Scanner;
import Queue.QueImps;

public class QueImps {
    static int size;
    static int start=-1,end=-1;
    static int[] que ;
    static int currsize=0;

    public static void Push(int data){
        if(currsize==size){
            System.out.println("queue overflow");
            return;
        }
        if(start == -1 && end == -1){
            start+=1;
            end+=1;
            que[start]=data;
            currsize+=1;
        }
        else{
            end = (end+1)%size;
            que[end] = data;
            currsize+=1;
        }
    }

    public static void Pop(){
        if(start == -1 && end == -1){
            System.out.println("queue underflow");
            return;
        }
        if(start == end){
            System.out.println("Popped element is "+que[start]);
            start = -1;
            end=-1;   
            currsize=0;
        }
        else{
            System.out.println("Popped element is "+que[start]);
            start=(start+1)%size; 
            currsize-=1;
        }
    }

    public static int Top(){
        if(start == -1 && end == -1){
            return -1;
        }
        return que[start];
    }

    public static int Size(){
        return currsize;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the Queue");
        size = sc.nextInt();
        que = new int[size];
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
                    System.out.println("enter data");
                    int n=sc.nextInt();
                    Push(n);
                    break;
                case 2:
                    Pop();
                    break;
                case 3:
                    System.out.println(Top());
                    break;
                case 4:
                    System.out.println(Size());
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

