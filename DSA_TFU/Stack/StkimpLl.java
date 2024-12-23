package Stack;
//Stack implementation using stack.

import java.util.Scanner;

public class StkimpLl {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;
    static int size=0;

    public static Node Push(Scanner sc){
        System.out.println("Enter data");
        int data = sc.nextInt();
        // if(data == -1){
        //     return null;
        // }
        Node node = new Node(data); 
        // if(head == null){
        //     head = node;
        //     top = node;
        //     size++;
        // }
        // else{
        //     top.next=node;
        //     top=node;
        //     top.next =null;
        //     size++;
        // }
        node.next = top;
        top = node;
        size++;
        System.out.println("data pushed");
        return node;
    }

    public static Node Pop(Node top){
        if(top == null){
            System.out.println("Stack is empty");
            return null;
        }
        System.out.println("Popped data is "+top.data);
        top=top.next;
        size--;
        return top;
    }

    public static int Size(){
        return size;
    }

    public static void print(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node list = null;
        for(int i=0;i<4;i++){
            list = Push(sc); 
        }
        print(list);
        list=Pop(list);
        print(list);
        System.out.println("\n"+Size());
    }
}
