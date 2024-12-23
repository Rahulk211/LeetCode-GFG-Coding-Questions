public class GameOfLife {

    private static void gameOfLife(int[][] board){
        int[][] cln = new int[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                cln[i][j] = board[i][j];
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(cln[i][j]==1){
                    int liveNeighbours = countLiveNeighbours(cln, i, j);
                    if(liveNeighbours==2 || liveNeighbours==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j]=0;
                    }
                }
                else{
                    if(countLiveNeighbours(cln,i,j)==3){
                        board[i][j]=1;
                    }
                    else{
                        board[i][j] = 0;
                    }
                }
            }
        }
    }
    private static int countLiveNeighbours(int[][] b,int i,int j){
        int live =0;
        if(i+1<b.length && b[i+1][j]==1) live++;
        if(j+1<b[0].length && b[i][j+1]==1) live++;
        if(i-1>=0 && b[i-1][j]==1) live++;
        if(j-1>=0 && b[i][j-1]==1) live++;

        if(i+1<b.length && j+1<b[0].length && b[i+1][j+1]==1) live++;
        if(i+1<b.length && j-1>=0 && b[i+1][j-1]==1) live++;
        if(i-1>=0 && j+1<b[0].length && b[i-1][j+1]==1) live++;
        if(i-1>=0 && j-1>=0 && b[i-1][j-1]==1) live++;

        return live;
    }
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
