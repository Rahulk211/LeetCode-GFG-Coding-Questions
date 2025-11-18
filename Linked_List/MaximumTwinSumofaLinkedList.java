import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MaximumTwinSumofaLinkedList {

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

    private static int pairSum(Node head){
        // Stack<Integer> stk = new Stack<>();
        // Node temp = head;
        // while(temp != null){
        //     stk.add(temp.data);
        //     temp = temp.next;
        // }

        // temp = head;
        // int max = Integer.MIN_VALUE;
        // while(temp != null){
        //     max = Math.max(max, temp.data + stk.pop());
        //     temp = temp.next;
        // }

        // return max;

        List<Integer> arr = new ArrayList<>();
        Node temp = head;
        while(temp != null){
            arr.add(temp.data);
            temp = temp.next;
        }
 
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.size()/2;i++){
            max = Math.max(max, arr.get(i) + arr.get(arr.size()-i-1));
        }
        return max;
    }  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createNode(sc);
        System.out.println(pairSum(head));
    }
}
