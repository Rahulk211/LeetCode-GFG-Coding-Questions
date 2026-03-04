import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSumII{

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(){};
        // TreeNode(int data) {
        //     this.data = data;
        // }
        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode builTreeNode(Scanner sc){
        int data = sc.nextInt();
        if(data < 0){
            return null;
        }

        TreeNode root = new TreeNode(data);
        System.out.print("Enter data left to " + data + " : ");
        root.left = builTreeNode(sc);
        System.out.print("Enter data right to " + data + " : ");
        root.right = builTreeNode(sc);

        return root;
    }

    
    private static List<List<Integer>> pathSum(TreeNode root, int targetSum){
        if(root == null) return null;

        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, 0, res, new ArrayList<>());

        return res;
    }

    private static void dfs(TreeNode root, int targetSum, int currSum, List<List<Integer>> res, List<Integer> currPath){
        if(root == null) return ;

        currSum += root.data;
        currPath.add(root.data);

        if(root.left == null && root.right==null && currSum == targetSum){
            res.add(new ArrayList<>(currPath));
        }

        dfs(root.left, targetSum, currSum, res, currPath);
        dfs(root.right, targetSum, currSum, res, currPath);

        currPath.remove(currPath.size()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = builTreeNode(sc);

        int targetSum = 22;

        System.out.println(pathSum(root, targetSum));
    }
}