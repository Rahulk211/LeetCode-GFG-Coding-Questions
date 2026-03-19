public class CountSubmatricesWithEqualFrequencyofXandY {

    private static int numberOfSubmatrices(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int res =0;
        int[] sumx = new int[n], sumy= new int[n];
        
        for(int i=0;i<m;i++){
            int rx=0,ry=0;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 'x') rx++;
                else if(grid[i][j] == 'y') ry++;

                sumx[j] += rx;
                sumy[j] += ry;

                if(sumx[j] > 0 && sumx[j] == sumy[j]) res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        char[][] grid = {{'x','y','.'}, {'y','.','.'}};

        System.out.println(numberOfSubmatrices(grid));
    }
}
