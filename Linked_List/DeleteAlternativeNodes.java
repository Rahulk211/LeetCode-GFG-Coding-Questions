import java.util.Scanner;

public class DeleteAlternativeNodes {
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
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

    private static void deleteAlt(Node head){
        if (head == null || head.next == null) {
            return; // Base case: 0 or 1 node
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr = curr.next.next;
            prev = prev.next;
        }

        if (curr != null) {
            prev.next = null; // Handle the case where the list has an odd number of nodes
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createNode(sc);    //778 759 957 936 649 630 226 882 221
        printList(head);
        deleteAlt(head);
        printList(head);
    }   
}
