import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_a_K_Sorted_Doubly_LinkedList {

    static class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    static Node head, tail;

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
            head.previous = null;
            tail.next = null;
        } else {
            // tail.Previous = tail;
            tail.next = node;
            node.previous = tail;
            tail = node;
            tail.next = null;
        }

        System.out.println("Enter next element : " + data);
        node.next = createNode(sc);

        return node;
    }

    public static void printList(Node list) {
        Node temp1 = list;
        System.out.println("serial traversal : ");
        while (temp1 != null) {
            System.out.print(temp1.data + " ");
            temp1 = temp1.next;
        }
    }

    private static Node sortAKSortedDLL(Node head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data - b.data);
        int i = 0;
        while (i <= k && head != null) {
            pq.add(head);
            head = head.next;
            i++;
        }
        Node temp = null;
        Node curr = null;
        while (!pq.isEmpty()) {
            if (temp == null) {
                temp = pq.poll();
                temp.next = null;
                temp.previous = null;
                curr = temp;
            } else {
                curr.next = pq.poll();
                curr.next.previous = curr;
                curr = curr.next;
            }
            if (head != null && pq.size() < k) {
                pq.add(head);
                head = head.next;
            }
        }
        curr.next = null;
        return temp;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the value of K : ");
        int k = sc.nextInt();
        head = createNode(sc);
        sc.close();
        printList(head);

        Node sorted = sortAKSortedDLL(head, k);
        printList(sorted);
    }

}
