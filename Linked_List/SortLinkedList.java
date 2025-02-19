//Sorting the linked list using merge sort.

import java.util.Scanner;

public class SortLinkedList {

    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    // private static ListNode head = null;

    private static ListNode buildList(Scanner sc){
        System.out.println("Enter data");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        } 

        ListNode node = new ListNode(data);
        // if(head == null){
        //     head = node;
        // }

        node.next = buildList(sc);

        return node;
    }
    // to divide unsorted list similar to merge sort on array.
    private static ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMidOfList(head);
        ListNode righthead = mid.next;
        mid.next = null;
        ListNode lefthead = head;

        lefthead = sortList(lefthead);
        righthead = sortList(righthead);

        return merge(lefthead,righthead);

    }

    // FindmidOfList returns the middle of the list and 
    // uses fast and slow  pointer approach to locate the 
    // middle node.

    private static ListNode findMidOfList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge function will merge the two list in a sorted manner.
    //@SuppressWarnings("unused")
    private static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(list1 != null && list2 != null){
           if(list1.data < list2.data){
            current.next = list1;
            current = list1;
            list1 = list1.next;
           }
           else{
            current.next = list2;
            current = list2;
            list2 = list2.next;
           }
        }
        if(list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        return dummy.next;
    }

    private static void PrintList(ListNode head){
        ListNode temp = head;

        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListNode head = buildList(sc);
        sc.close();

        System.out.println("Given List: - " + head);

        head = sortList(head);

        PrintList(head);
    }
    
}
