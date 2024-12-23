import java.util.Scanner;

public class BinaryTreeMaximumPathSum {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(Scanner sc){
        System.out.println("enter data");
        int data = sc.nextInt();

        if(data < 0){
            return null;
        }

        TreeNode root = new TreeNode(data);

        root.left = buildTree(sc);
        root.right = buildTree(sc);
        
        return root;
    }

    private static int maxPathSum(TreeNode root){
        int[] maxvalue = new int[1];
        maxvalue[0] = Integer.MIN_VALUE;
        maxpathdown(root,maxvalue);

        return maxvalue[0];
    }

    private static int maxpathdown(TreeNode root, int[] maxvalue){
        if(root == null){
            return 0;
        }
        
        int leftsum = Math.max(0,maxpathdown(root.left,maxvalue));
        int rightsum = Math.max(0,maxpathdown(root.right,maxvalue));
        maxvalue[0] = Math.max(maxvalue[0], leftsum+rightsum+root.data);
        return root.data + Math.max(leftsum,rightsum);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc);
        
        
        System.out.println(maxPathSum(root));
    }
}
