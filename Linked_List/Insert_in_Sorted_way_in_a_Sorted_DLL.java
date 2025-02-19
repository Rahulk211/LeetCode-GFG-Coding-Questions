import java.util.Scanner;

public class Insert_in_Sorted_way_in_a_Sorted_DLL {

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

    static Node head = null;
    static Node tail = null;

    static void DoublyLl(Scanner sc) {
        int data = sc.nextInt();

        if (data == -1) {
            return ;
        }

        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
            head.Previous = null;
            tail.next = null;
        } else {
            // tail.Previous = tail;
            tail.next = node;
            node.Previous = tail;
            tail = node;
            tail.next = null;
        }
        System.out.print("Enter next data : ");
        DoublyLl(sc);
    }

    public static void printList(Node list){
        Node temp1=list;
        System.out.println("serial traversal : ");
        while(temp1!=null){
            System.out.print(temp1.data+" ");
            temp1=temp1.next;
        }
    }

    private static Node sortedInsert(Node head, int data) {
        Node node = new Node(data);
    
        // Case 1: Insert at the beginning (or if the list is empty)
        if (head == null || head.data >= data) {
            node.next = head; // New node points to the current head
            if (head != null) {
                head.Previous = node; // Update the previous head's Previous reference
            }
            return node; // New node becomes the new head
        }
    
        Node current = head;
        // Traverse the list to find the correct insertion point
        while (current.next != null && current.next.data < data) {
            current = current.next;
        }
    
        // Insert the new node
        node.next = current.next; // Link to the next node
        if (current.next != null) {
            current.next.Previous = node; // Update the next node's Previous reference
        }
        current.next = node; // Link the current node to the new node
        node.Previous = current; // Set the Previous reference of the new node
    
        return head; // Return the head of the list
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data in list in a sorted manner : ");
        DoublyLl(sc);
        printList(head);

        System.out.print("\nEnter data to be inserted : ");
        int data = sc.nextInt();
        Node newHead = sortedInsert(head, data);
        printList(newHead);
    }
}
