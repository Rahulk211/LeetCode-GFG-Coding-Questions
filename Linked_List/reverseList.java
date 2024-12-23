
import java.util.Scanner;

public class reverseList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    public static Node Insertion(Scanner sc) {
        System.out.println("enter data");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            // tail.next=null;
        } else {
            tail.next = node;
            tail = node;
        }
        node.next = Insertion(sc);

        return node;
    }

    public static Node ReverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }

    public static void PrintList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("->" + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = Insertion(sc);
        PrintList(head);
        head = ReverseList(head);
        System.out.println();
        PrintList(head);
        sc.close();
    }

}
