import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leaf_SimilarTrees {
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

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        return leaves1.equals(leaves2);
    }

    private static List<Integer> getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return leaves;
        }
        if (node.left == null && node.right == null) {
            leaves.add(node.data);
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
        return leaves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root1 = buildTree(sc);
        TreeNode root2 = buildTree(sc);
        
        System.out.println(leafSimilar(root1, root2));
    }
}
