import java.util.Scanner;

public class OddEvenLinkedList {
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

    private static Node oddEvenList(Node head){
        if(head == null) return null;

        Node odd = head;
        Node even = head.next;
        Node evenhead = even;

        while(odd.next != null && even.next != null){           // 1->2->3->4->5->6
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenhead;

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createNode(sc);
        head = oddEvenList(head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        sc.close();
    }
}
