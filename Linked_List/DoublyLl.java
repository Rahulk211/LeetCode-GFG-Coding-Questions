// package Linked_List;

import java.util.Scanner;

public class DoublyLl {
   
    public static class Node {
        int data;
        Node next;
        Node Previous;
       

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.Previous = null;
        }
    }
        static Node head;
        static Node tail;

        public static Node createNode(Scanner sc) {
            System.out.println("Enter data : ");
            int data = sc.nextInt();

            if (data == -1) {
                return null;
            }

            Node node = new Node(data);

            if (head == null) {
                head = node;
                tail = node;
                head.Previous = null;
                tail.next=null;
            } else {
                //tail.Previous = tail;
                tail.next = node;
                node.Previous = tail;
                tail = node;
                tail.next = null;
            }

            System.out.println("Enter next element : ");
            node.next = createNode(sc);

            return node;
        }

        public static void printList(Node list){
            Node temp1=list;
            System.out.println("serial traversal : ");
            while(temp1!=null){
                System.out.print(temp1.data+" ");
                temp1=temp1.next;
            }
            
            System.out.println();
            temp1 = tail;
            
            System.out.println("Reversal traversal : ");
            while(temp1!=null){
                System.out.print(temp1.data+" ");
                temp1=temp1.Previous;
            }           
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            Node list = createNode(sc);

           // System.out.println("Press 1 to print list form head or press 2 to print list from tail");
            //int option = sc.nextInt();

            printList(list);
            sc.close();
        }
    
}
