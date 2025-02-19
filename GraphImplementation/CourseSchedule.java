/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
 * take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to 
 * take course 0 you have to first take course 1.
 * 
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So it is possible.
 * 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CourseSchedule {
    private static boolean canFinish(int n, int[][] prerequisites){
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

        List<Integer>  topo = new ArrayList<>();


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

        if(topo.size() == n)  return true;

        return false;

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

        System.out.println(canFinish(numOfCourse,prerequisites));
    }
    
}
