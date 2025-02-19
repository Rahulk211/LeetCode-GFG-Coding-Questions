import java.util.Scanner;

public class Quick_Sort_on_Linked_List {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node LinkedList(Scanner sc) {
        int data = sc.nextInt();

        if (data < 0) {
            return null;
        }
        Node head = new Node(data);

        System.out.print("Enter next data : ");
        head.next = LinkedList(sc);

        return head;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static Node findTail(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }

    private static Node quickSort(Node head) {
        Node tail = findTail(head);
        quickSortUtil(head, tail);

        return head;
    }

    private static void quickSortUtil(Node head, Node tail) {
        if (head == null || head == tail || head == tail.next) {
            return;
        }
    
        Node pivotNode = partition(head, tail);
    
        // Sort the left side of the pivot
        quickSortUtil(head, pivotNode);
    
        // Sort the right side of the pivot
        if (pivotNode != null && pivotNode.next != null) {
            quickSortUtil(pivotNode.next, tail);
        }

        
    }

    private static Node partition(Node head, Node tail) {
        int pivotValue = head.data;
        Node prev = head, curr = head.next;

        while (curr != tail.next) {
            if (curr.data < pivotValue) {
                prev = prev.next;

                // Swap i and j data
                int temp = prev.data;
                prev.data = curr.data;
                curr.data = temp;
            }
            curr = curr.next;
        }

        // Swap pivot with current position of i
        int temp = prev.data;
        prev.data = head.data;
        head.data = temp;

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data : ");
        Node head = LinkedList(sc); // 7 8 10 2 2 10 1 4 6 9 10
        printList(head);

        quickSort(head);

        System.out.println("Sorted linked list : ");
        printList(head);
    }
}