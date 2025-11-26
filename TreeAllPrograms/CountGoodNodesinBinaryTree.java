import java.util.Scanner;

public class CountGoodNodesinBinaryTree {
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
        if(data == -1){
            return null;
        }

        TreeNode root = new TreeNode(data);
        System.out.print("Enter data left to " + data + " : ");
        root.left = builTreeNode(sc);
        System.out.print("Enter data right to " + data + " : ");
        root.right = builTreeNode(sc);

        return root;
    }

    private static int countGoodNodes(TreeNode root, int max){
        if(root == null){
            return 0;
        }
        int count = 0;
        if(root.data >= max){
            count = 1;
            max = root.data;
        }
        count += countGoodNodes(root.left, max);
        count += countGoodNodes(root.right, max);
        return count;
    }

    private static int goodNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return countGoodNodes(root, root.data);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        TreeNode root = builTreeNode(sc);
        System.out.println(goodNodes(root));
        
    }
}
