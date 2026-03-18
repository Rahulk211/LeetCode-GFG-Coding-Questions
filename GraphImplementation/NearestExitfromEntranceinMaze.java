import java.util.LinkedList;
import java.util.Queue;

public class NearestExitfromEntranceinMaze{

    private static int nearestExit(char[][] maze, int[] entrance){
        
        return bfs(maze, entrance);
    }

    private static int bfs(char[][] maze, int[] entrance){
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int level = 0;

        int[][] dir = {{0,1},{1,0}, {-1,0},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                if((x!= entrance[0] || y!= entrance[1]) && (x==0 || x==maze.length-1
                    || y==0 || y==maze[0].length-1)){
                        return level;
                }

                for(int[] d : dir){
                    int nx = x+d[0];
                    int ny = y+d[1];
                    System.out.println(nx +" "+ny);
                    if(nx>=0 && ny>=0 && nx <maze.length && ny <maze[0].length && maze[nx][ny]!='+'){
                        q.add(new int[]{nx,ny});
                        maze[nx][ny] = '+';
                    }
                }
            }
            level++;
        }

        return -1;
    }
    public static void main(String[] args) {
        char[][] maze = {{'+','+','+'}, {'.','.','.'}, {'+','+','+'}};
        int[] entrance = {1,0};

        System.out.println(nearestExit(maze, entrance));
    }
}