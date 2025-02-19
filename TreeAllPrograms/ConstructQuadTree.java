public class ConstructQuadTree {

    static class QNode{
        boolean val;
        boolean isleaf;
        QNode Topleft;
        QNode Topright;
        QNode Bottomleft;
        QNode Bottomright;

        public QNode(){
            val = false;
            isleaf = false;
            Topleft = null;
            Topright = null;
            Bottomleft = null;
            Bottomright = null;
        }

        public QNode(boolean val, boolean isleaf){
            this.val = val;
            this.isleaf = isleaf;
            Topleft = null;
            Topright = null;
            Bottomleft = null;
            Bottomright = null;
        }

        public QNode(boolean val, boolean isleaf, QNode Topleft,QNode Topright, QNode Bottomleft, QNode Bottomright){
            this.val = val;
            this.isleaf = isleaf;
            this.Topleft = Topleft;
            this.Topright = Topright;
            this.Bottomleft = Bottomleft;
            this.Bottomright = Bottomright;
        }
    }

    private static boolean isEqual(int x, int y, int[][] grid,int n){
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(grid[i][j]!=grid[x][y]){
                    return false;
                }
            }
        }
        return true;
    }

    private static QNode solve(int x1,int y1, int[][] grid,int length){
        if(isEqual(x1, y1, grid, length)){
            if(grid[x1][y1] == 1){
                return new QNode(true, true);
            }
            return new QNode(false, true);
        }
        QNode root = new QNode(false,false);
        root.Topleft = solve(x1,y1,grid,length/2);
        root.Topright = solve(x1,y1+length/2,grid,length/2);
        root.Bottomleft = solve(x1+length/2,y1,grid,length/2);
        root.Bottomright = solve(x1+length/2,y1+length/2,grid,length/2);

        return root;
    }

    private static QNode construct(int[][] grid){
        return solve(0,0,grid,grid.length);
    }

    private static void printQuadTree(QNode root){
        if(root.isleaf){
            System.out.println(root.val);
            }
        else
        {
            System.out.println("true");

            printQuadTree(root.Topleft);
            printQuadTree(root.Topright);     
            printQuadTree(root.Bottomleft);
            printQuadTree(root.Bottomright);
                    
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        QNode root = construct(grid);

        printQuadTree(root);
    }
}
