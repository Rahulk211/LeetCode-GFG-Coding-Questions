import java.util.Scanner;

public class FlipEquivalentBinaryTrees {

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

    public static void printTreeInOrder(TreeNode root){
        if(root==null){
            return;
        }

        printTreeInOrder(root.left);
        System.out.print(root.data+" ");
        printTreeInOrder(root.right);

    }

    private static boolean flipEquiv(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }
        else if(root1.data != root2.data){
            return false;
        }

        boolean isEquivalent = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if(isEquivalent){
            return true;
        }

        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root 1 data : ");
        TreeNode root1 = builTreeNode(sc);
        System.out.print("Enter root 2 data : ");
        TreeNode root2 = builTreeNode(sc);
        System.out.print("Root 1 : ");
        printTreeInOrder(root1);
        System.out.println("Root 2 : ");
        printTreeInOrder(root2);

        System.out.println(flipEquiv(root1, root2));

    }
}
