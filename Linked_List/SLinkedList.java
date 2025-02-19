import java.util.Scanner;

public class SLinkedList{
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    } 

    static Node createNode(Scanner sc){
        System.out.print("Enter data : ");
        int data=sc.nextInt();

        if(data==-1){
            return null;
        }

        Node node = new Node(data);

        System.out.println("enter next node of list :- ");
        node.next=createNode(sc);

        return node;        
    }

    static void printList(Node head){
        System.out.println("Printing the linkedlist");

        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Node head = createNode(sc);
            printList(head);
        }
    }
}