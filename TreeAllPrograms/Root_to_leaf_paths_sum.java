import java.util.Scanner;

public class Root_to_leaf_paths_sum {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

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

    public static void inordertraversal(TreeNode root){
        if(root == null){
            return;
        }
        inordertraversal(root.left);
        System.out.print(root.data +" ");
        inordertraversal(root.right);
    }

    private static int help(TreeNode root, int parent){
        if(root == null) return 0;
        parent = 10*parent + root.data;
        if(root.left == null && root.right == null){
            return parent;
        }

        return help(root.left, parent) + help(root.right, parent);
    }

    private static int treePathsSum(TreeNode root ){
        if (root == null) {
            return 0;
        }
        return help(root, 0);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data : ");
        TreeNode root = builTreeNode(sc);
        System.out.print("Inorder Traversal of the tree is : ");
        inordertraversal(root);
        System.out.println();

        int ans = treePathsSum(root);
        System.out.println(ans);
    }
}
