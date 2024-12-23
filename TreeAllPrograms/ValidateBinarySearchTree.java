import java.util.Scanner;

public class ValidateBinarySearchTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left =null;
            this.right = null;
        }
    }
    
    public static TreeNode buildTree(Scanner sc){
        System.out.println("Enter data");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        TreeNode root = new TreeNode(data);
        root.left = buildTree(sc);
        root.right = buildTree(sc);

        return root;
    }

    public static boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.data <= min || root.data >= max) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);   
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
