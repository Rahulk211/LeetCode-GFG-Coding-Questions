public class FloodFillAlgo {
    
    private static int[][] floodFill(int[][] image, int nc,int sr,int sc){

        int[][] nImg = image.clone();
        int oldColor = image[sr][sc];
        
        DFS(nImg, oldColor,nc,sr,sc);

        return nImg;
    }

    private static void DFS(int[][] nImg, int oc, int nc, int sr, int sc){
        nImg[sr][sc] = nc;

        if(sr-1>=0  && nImg[sr-1][sc] != nc){
            DFS(nImg,oc,nc,sr-1,sc);
        }
        if(sr+1<nImg.length  && nImg[sr+1][sc] == oc){
            DFS(nImg,oc,nc,sr+1,sc);
        }
        if(sc-1>=0  && nImg[sr][sc-1] == oc){
            DFS(nImg,oc,nc,sr,sc-1);
        }
        if(sc+1<nImg[0].length  && nImg[sr][sc+1] == oc){
            DFS(nImg,oc,nc,sr,sc+1);
        }

    }
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,2,2},{2,2,2}};
        int ncolor = 3;
        int sr = 1;
        int sc = 1;

        int[][] newImage = floodFill(image,ncolor,sr,sc);
        for(int i=0;i<newImage.length;i++){
            for(int j=0;j<newImage[0].length;j++){
                System.out.print(newImage[i][j]+" ");
            }
            System.out.println();
        }
    }
}
