import java.util.Scanner;

public class Occurence_of_an_integer_in_a_Linked_List {

    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    } 

    static Node createNode(Scanner sc){
        int data=sc.nextInt();

        if(data==-1){
            return null;
        }

        Node node = new Node(data);

        System.out.println("enter next node of list :- ");
        node.next=createNode(sc);

        return node;        
    }

    private static int count(Node head, int key){
        if(head == null){
            return 0;
        }
        int count = 0;
        Node temp = head;

        while(temp != null){
            if(temp.data == key){
                count++;
            }
            temp = temp.next;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data : ");
        Node head = createNode(sc);
        System.out.print("Enter the value of key : ");
        int key = sc.nextInt();


        System.out.println("occurence of "+key+" is "+count(head,key));
    }
    
}
