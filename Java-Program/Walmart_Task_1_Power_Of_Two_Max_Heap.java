import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Walmart_Task_1_Power_Of_Two_Max_Heap {
    private List<Integer> heap;
    private int child_Count;

    Walmart_Task_1_Power_Of_Two_Max_Heap(int child_Count){
        this.heap = new ArrayList<>();
        this.child_Count = child_Count;
    }
    
    // Method to insert new value in the heap
    private void insert(int data){
        heap.add(data);
        bubbleUp(heap.size()-1);
    }

    //Method to remove and return the max value from heap
    private int popMax(){
        if(heap.size() == 0) return -1;

        int max = heap.get(0);
        int last = heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            heap.set(0, last);    //move last element to root  
            bubbleDown(0);             //Restore heap priority
        }

        return max;
        
    }

    // Method to restore heap Priority while insertion 
    private void bubbleUp(int index){
        int curr = index;
        while (curr > 0) {
            int parent = (curr - 1) / child_Count; // Calculate the parent index
            if (heap.get(curr) > heap.get(parent)) {
                swap(curr, parent); // Swap if the current node is greater than its parent
                curr = parent; // Move up to the parent's index
            } else {
                break; // Stop if the heap property is satisfied
            }
        }
    }

    // method to restore heap Priority while pop max
    private void bubbleDown(int index){
        int curr = index;
        int size = heap.size();
        
        while (true) {
            int largest = curr;
            // Check all children
            for (int i = 1; i <= child_Count; i++) {
                int childIndex = child_Count * curr + i; // Calculate child index
                if (childIndex < size && heap.get(childIndex) > heap.get(largest)) {
                    largest = childIndex; // Find the largest child_count
                }
            }
            if (largest == curr) break; // If the largest is the current, we are done
            swap(curr, largest); // Swap with the largest child
            curr = largest; // Move down to the largest child's index
        }
    }

    // Helper method to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Walmart_Task_1_Power_Of_Two_Max_Heap maxheap = new Walmart_Task_1_Power_Of_Two_Max_Heap(1);
        int choice = 0;
        do{
            System.out.println("Press 0. to Enter to insert\nPress 1. to Enter to insert\nPress -1. to Enter to insert ");
            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    System.out.print("enter data : ");
                    int n = sc.nextInt();
                    maxheap.insert(n);
                    break;
                
                case 1:
                    System.out.println(maxheap.popMax());
                    break;
                
                default :
                    System.out.println("Invalid choice");
            }
        }while(choice != -1);
        sc.close();
    }
}
