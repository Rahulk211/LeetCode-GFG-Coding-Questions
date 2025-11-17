import java.util.Scanner;

public class DeletetheMiddleNodeofaLinkedList {
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

    private static Node deleteMiddle(Node head){
        if(head == null || head.next == null){
            return head; // If the list is empty or has only one node
        }

        Node slow = head;
        Node fast = head;
        fast = fast.next.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next; // Delete the middle node
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createNode(sc);
        sc.close();

        Node modified = deleteMiddle(head);
        while(modified != null){
            System.out.print(modified.data + " ");
            modified = modified.next;
        }
        
    }
}
