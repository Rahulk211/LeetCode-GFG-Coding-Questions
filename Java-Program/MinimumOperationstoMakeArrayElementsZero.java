public class MinimumOperationstoMakeArrayElementsZero {

    private static long getOps(int n){
        long curr=1;
        long res=0;
        int mul=1;
        while(curr<=n){
            long nxt = Math.min(curr*4, n+1);
            long cnt = (nxt - curr);
            res += cnt*mul;
            mul++;
            curr = nxt;
        }
        return res;
    }

    private static long minOperations(int[][] queries){
        long res=0;
        for(int[] q:queries){
            int l = q[0];
            int r = q[1];
            long x = getOps(l-1);
            long y = getOps(r);
            res += (y-x) %2==0? (y-x)/2: (y-x+1)/2;
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] queries = {{1,5},{2,3},{3,1},{5,2}};

        System.out.println(minOperations(queries));
    }
}
