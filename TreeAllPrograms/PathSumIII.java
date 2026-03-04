import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PathSumIII {

    static Map<Long, Integer> map = new HashMap<>();
    static int cnt=0;

    private static int pathSum(TreeNode root, int targetSum){

        map.put(0L, 1);
        solve(root, targetSum, 0L);

        return cnt;
    }

    private static void solve(TreeNode root, int targetSum, long sum){
        if(root == null) return;

        sum += root.val;

        cnt += map.getOrDefault(sum-targetSum, 0);

        map.put(sum, map.getOrDefault(sum, 0)+1);

        solve(root.left, targetSum, sum);
        solve(root.right, targetSum, sum);

        map.put(sum, map.get(sum) -1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode().buildTree(sc);
        System.out.println("Enter target value : ");
        int targetSum = sc.nextInt();

        System.out.println(pathSum(root, targetSum));

    }
}
