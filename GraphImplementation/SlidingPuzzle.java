import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle {

    private static int slidingPuzzle(int[][] board){
        Queue<String> q = new LinkedList<>();
        String tar = "123450";
        StringBuilder initial = new StringBuilder();
        for(int i=0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                initial.append(board[i][j]);
            }
        }
        q.add(initial.toString());
        int[][] swapidx = {{1,3},{0,2,4,},{1,5},{0,4},{1,3,5},{2,4}};
        HashSet<String> visited = new HashSet<>();
        visited.add(initial.toString());
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String rem = q.poll();
                if(rem.equals(tar)){
                    return level;
                }
                int idx = -1;
                for(int i=0;i<rem.length();i++){
                    if(rem.charAt(i)=='0'){
                        idx = i;
                        break;
                    }
                }
                int[] swap = swapidx[idx];
                for(int idxs : swap){
                    String tobeadded = swapChar(rem, idx,idxs);
                    if(visited.contains(tobeadded)){
                        continue;
                    }
                    q.add(tobeadded);
                    visited.add(tobeadded);
                }
            }
            level++;
        }
        return -1;
    }

    static String swapChar(String rem,int i,int idx){
        char[] arr = rem.toCharArray();
        char temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
        return new String(arr);
    }
    public static void main(String[] args) {
        int[][] puzzle = {{1,2,3},{5,4,0}};
        System.out.println(slidingPuzzle(puzzle));
    }
}
