

import java.util.ArrayList;
import java.util.Scanner;

public class AdjListImplementation {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void createList(Scanner sc, int n){
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>() );
        }
        for(int i=1;i<=n;i++){

            int v1=sc.nextInt();
            int v2=sc.nextInt();

            list.get(v1).add(v2);
            list.get(v2).add(v1);

        }

    }

    public static void printAdjList(){
        for(int i=0;i<list.size();i++){
            System.out.print(i+"->");
            for(int j=0;j<list.get(i).size();j++){
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    } 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n=sc.nextInt();
        createList(sc,n);
        printAdjList();
        sc.close();
    }
}
