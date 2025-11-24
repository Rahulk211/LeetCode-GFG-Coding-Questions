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

        // List<Integer> arr = new ArrayList<>();
        // Node temp = head;
        // while(temp != null){
        //     arr.add(temp.data);
        //     temp = temp.next;
        // }
 
        // int max = Integer.MIN_VALUE;
        // for(int i=0;i<arr.size()/2;i++){
        //     max = Math.max(max, arr.get(i) + arr.get(arr.size()-i-1));
        // }
        // return max;

        Node slow = head, fast = head;

        while(fast != null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow, prev = null, Next = null;

        while(curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        Node f_half = head;
        Node s_half = prev;
        int max = Integer.MIN_VALUE;

        while(s_half != null && f_half!=null){
            max = Math.max(max, f_half.data + s_half.data);
            f_half = f_half.next;
            s_half = s_half.next;
        }

        return max;
    }  

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = createNode(sc);
        System.out.println(pairSum(head));
    }
}
