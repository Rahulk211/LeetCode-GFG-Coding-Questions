import java.util.Scanner;

public class CircularList {
    public static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    static Node head;
    static Node tail; 

    public static Node CreateNode(Scanner sc){
        System.out.println("Enter data or -1 to exit");
        int data=sc.nextInt();
        
        if(data ==-1){
            return null;
        }

        Node node=new Node(data);
        if(head==null){
            head =node;
            tail=node;
            tail.next =head;
        }
        else{
            tail.next=node;
            tail.next=head;
        }
        node.next = CreateNode(sc);

        return node;
    }

    public static void PrintList(Node head){
        if(head == null){
            return;
        }
        Node temp=head;

        do{
            System.out.print(temp.data+" ");
            temp=temp.next;
        }while(temp!=head);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node list = CreateNode(sc);
        sc.close();
        System.out.println("Circular Linked List is: ");
        PrintList(list);
    }
}
