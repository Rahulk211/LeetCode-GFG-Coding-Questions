import java.util.Scanner;

public class LLinsertion {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;

    static Node insertionAtEnd(Scanner sc) {
        System.out.println("Enter data : ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node node = new Node(data);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=node;
        }
        // System.out.println("enter next node element :- ");
        // node.next = insertionAtEnd(sc);

        return head;
    }

    static Node insertionAtstart(Scanner sc) {
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            Node temp = head;
            head = node;
            head.next = temp;
        }
        // System.out.println("enter next node element :- ");
        // node.next = insertionAtstart(sc);
        return head;
    }

    static Node insertionAtMid(Scanner sc){
        System.out.println("Enter data: ");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        System.out.println("Enter data befor which data is to be inserted ");
        int position = sc.nextInt();
        Node node = new Node(data);
        Node temp = head;
        while(temp.next!=null && temp.next.data!=position){
            temp=temp.next;
        }
        if(temp.next==null){
            return head;
        }
        else{
            node.next=temp.next;
            temp.next=node;
            // node.next=temp.next;
            // temp=node;
        }

        return head;
    }

    //delection from the start.
    static Node DelectionAtStart(Node head){
        if(head==null){
            return null;
        }
        else if(head.next==null){
            head=null;
        }
        else{
            head=head.next;
        }

        return head;
    }
    // Delection form the end.
    static Node DElectionAtEnd(Node head){
        if(head==null){
            return null;
        }
        else if(head.next==null){
            head = null;
        }
        else{
            Node temp =head;
            Node prev=null;
            while(temp.next!=null){
                prev=temp;
                temp = temp.next;
            }
            temp = prev;
            temp.next=null;
        }
        return head;
    }
    //delection at any position int he list.
    static Node DelectionAtPosition(Node head,Scanner sc){
        if(head == null){
            return null;
        }
        else{
            Node temp =head;
            Node prev=null;
            System.out.println("Enter the element to be deleted");
            int x = sc.nextInt();
            while(temp.data!=x){
                prev=temp;
                temp=temp.next;
            }
            prev.next=temp.next;
        }
        return head;

    }

    static void printList(Node head) {
        if(head==null){
            System.out.println("the list is empty");
        }
        else{
            System.out.println("Printing the linkedlist");

            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println("Inserting data at the starting");
        Node list = null;
        int option ;
        do{
            System.out.println("1. Insert at the start\n");
            System.out.println("2. Insert at the end\n");
            System.out.println("3. Insert at the middle\n");
            System.out.println("4. Delection at the start\n");
            System.out.println("5. Delection at the end\n");
            System.out.println("6. Delection at the position\n");
            System.out.println("7. Print the list\n");
            System.out.println("0. Press 0 to exit\n");
            System.out.print("Enter your choice : ");
            option = sc.nextInt();

            switch(option){
                case 1:
                    list = insertionAtstart(sc);
                    break;
                case 2:
                    list = insertionAtEnd(sc);
                    break;
                case 3:
                    list = insertionAtMid(sc);
                    break;
                case 4:
                    list =DelectionAtStart(list);
                    break;
                case 5:
                    list = DElectionAtEnd(list);
                    break;
                case 6:
                    list = DelectionAtPosition(list,sc);
                    break;
                case 7:
                    printList(list);
                    break;
                case 0:
                    System.out.println("Exiting the program");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }while(option!=0);
        sc.close();
    }

}
