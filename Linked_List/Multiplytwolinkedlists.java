import java.util.Scanner;

public class Multiplytwolinkedlists {

    private static class Node{
        long data;
        Node next;

        public Node(long data){
            this.data=data;
            this.next=null;
        }
    } 

    static Node createNode(Scanner sc){
        System.out.print("Enter data : ");
        long data=sc.nextInt();

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

    private static long multiplyTwoLists(Node h1, Node h2){
        long fst = listToNum(h1);
        long snd = listToNum(h2);

        return (fst*snd)%1000000007;
    }

    private static long listToNum(Node head){
        long num = 0, mod = (long) (1e9+7);
        while(head!=null){
            num = (num*10+head.data)%mod;
            head = head.next;
        }

        return num;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Node head1 = createNode(sc);
            Node head2 = createNode(sc);
            printList(head1);
            printList(head2);

            multiplyTwoLists(head1,head2);
        }
    }
    
}
