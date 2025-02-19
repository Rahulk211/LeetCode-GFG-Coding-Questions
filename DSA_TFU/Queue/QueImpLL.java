//Queue implementation using LinkedList.
package Queue;

import java.util.Scanner;

public class QueImpLL {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node start=null;
    static Node end=null;
    static int size=0;

    public static Node Push(int data){
        Node newnode=new Node(data);
        if(start==null && end==null){
            newnode.next=end;
            start=newnode;
            end=newnode;
            size++;
        }
        else{
            newnode.next=end;   
            end=newnode;
            size++;
        }

        return newnode;
    }

    public static Node Pop(Node list){
        if(start == null && end == null){
            System.out.println("underflow");
            return null;
        }
        if(start == end){
            System.out.println("Popped element is "+start.data);
            start = null;
            end = null;
            size--;
            return null;
        }
        System.out.println("Popped element is "+start.data);
        Node temp=start;
        start=start.next;
        size--;
        return temp;

    }

    public static void Print(Node list){
        Node temp = list;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Node List = null;
        for(int i=0;i<3;i++){
            System.out.println("Enter data");
            int data =sc.nextInt();
            List = Push(data);
        }

        Print(List);
        List=Pop(List);
        Print(List);
        sc.close();
    }
}
