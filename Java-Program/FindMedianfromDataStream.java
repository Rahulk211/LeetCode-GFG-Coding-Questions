import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindMedianfromDataStream {
    List<Integer> list;
    
    // public FindMedianfromDataStream(){
    //     list = new ArrayList<>();
    // }

    // void addnum(int num){
    //     list.add(num);
    //     Collections.sort(list);
    // }

    // double findMed(){
    //     int size = list.size();
    //     for(int i=0;i<size;i++){
    //         System.out.println(i+" "+list.get(i));
    //     }
    //     if(size % 2 != 0){
    //         return list.get(size/2);
    //     }
    //     else{
    //         return (double)(list.get(size/2 - 1) + list.get(size/2))/2;
    //     }
    // }

    PriorityQueue<Integer> high = new PriorityQueue<>();
    PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());

    public FindMedianfromDataStream(){

    }

    void addnum(int num){
        high.add(num);
        if(high.size() > low.size()){
            low.add(high.poll());
        }
        if(low.size() > high.size()){
            high.add(low.poll());
        }
    }
    double findMed(){
        if(high.size() == low.size()){
            return (double)(high.peek() + low.peek())/2;
        }
        else{
            return (double)high.peek();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FindMedianfromDataStream obj = new FindMedianfromDataStream();
        while(true){
            System.out.println("1. Add Number");
            System.out.println("2. Find Median");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
    
            switch(choice){
                case 1:
                    System.out.print("Enter a number: ");
                    int num = sc.nextInt();
                    obj.addnum(num);
                    break;
                
                case 2:
                    System.out.println("Median is: "+obj.findMed());
                    break;

                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default :
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}
