import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedList {

    public static LinkedList<Integer> mergeKList(LinkedList<Integer>[] list){
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b)-> a.get(0)-b.get(0));
        for(List<Integer> l: list){
            if(!l.isEmpty()){
                queue.offer(l);
            }
        }

        LinkedList<Integer> result = new LinkedList<>();
        
        while(!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            result.add(curr.get(0));
            curr.remove(0);
            if(!curr.isEmpty()){
                queue.offer(curr);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of list");
        int n = sc.nextInt();
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] lists = new LinkedList[n];
        for(int i = 0 ; i < n ; i++){
            LinkedList<Integer> l = new LinkedList<>();
            System.out.println("Enter the size of list " + (i+1));
            int m = sc.nextInt();
            System.out.println("Enter element of list " + (i+1));
            for(int j =0;j<m;j++){
                int ele = sc.nextInt();
                l.add(ele);
            }
            lists[i]=l;
        }
        sc.close();

        List<Integer> merged = mergeKList(lists);
        System.out.println("Merged List: - "+merged);
    }
}
