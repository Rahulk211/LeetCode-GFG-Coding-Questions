import java.util.Scanner;

public class SumofRootToLeafBinaryNumbers {

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

    private static int  sumRootToLeaf(TreeNode root){
        return DFS(root, 0);
    }

    private static int DFS(TreeNode root, int x){
        if(root == null) return 0;

        x = x*2 + root.data;
        if(root.left == root.right) return x;
        return DFS(root.left, x) + DFS(root.right, x);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        TreeNode root = builTreeNode(sc);

        System.out.println(sumRootToLeaf(root));
    }
}
