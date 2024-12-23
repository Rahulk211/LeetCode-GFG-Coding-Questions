import java.util.LinkedList;
import java.util.Scanner;

public class PartitionList {

    public static LinkedList<Integer> Partition(LinkedList<Integer> head, int x) {
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
    
        for (Integer num : head) {
            if (num < x) {
                left.add(num);
            } else {
                right.add(num);
            }
            
        }
        left.addAll(right);
        return left;
    }

    public static void printList(LinkedList<Integer> head){
        for(Integer num:head){
            System.out.print(num+" ");
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc =new Scanner(System.in);
        int size = sc.nextInt();
        int x = sc.nextInt();
        for(int i=0;i<size;i++){
            list.add(sc.nextInt());
        }
        list=Partition(list,x);
        printList(list);
        sc.close();

    }
}
