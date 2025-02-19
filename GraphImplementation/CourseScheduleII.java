import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CourseScheduleII {

     private static ArrayList<Integer> findOrder(int n, int[][] prerequisites){
        ArrayList<ArrayList<Integer>>  graph = new ArrayList<>();
        int m = prerequisites.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indeg = new int[n];
        for(int i=0;i<n;i++){
            for(int it : graph.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer>  topo = new ArrayList<>();


        while(!q.isEmpty()){
            int node  = q.peek();
            q.remove();
            topo.add(node);

            for(int it : graph.get(node)){
                indeg[it]--;
                if(indeg[it] == 0){
                    q.add(it);
                }
            }
        }

        if(topo.size() == n)  return topo;

        return new ArrayList<>() {};

    }

    public static void main(String[] args) {
        // Create a new CourseSchedule object
        Scanner sc = new Scanner(System.in);
        System.out.print("enter number of course to be taken : ");
        int numOfCourse = sc.nextInt();
        System.out.print("enter number of prerequisites : ");
        int n = sc.nextInt();
        int[][] prerequisites = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                prerequisites[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(findOrder(numOfCourse,prerequisites));
    }
    
}
