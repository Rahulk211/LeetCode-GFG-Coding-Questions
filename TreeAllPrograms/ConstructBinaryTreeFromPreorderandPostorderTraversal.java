import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinaryTreeFromPreorderandPostorderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int pre_idx=0;
    static int post_idx=0;

    public static TreeNode constructFromPrePost(int[] pre, int[] post){
        if(pre.length == 0 || post.length == 0) return null;
        TreeNode root = new TreeNode(pre[pre_idx]);
        pre_idx++;
        if(root.val!=post[post_idx]){
            root.left = constructFromPrePost(pre,post);
        }
        if(root.val!=post[post_idx]){
            root.right = constructFromPrePost(pre,post);
        }

        post_idx++;
        return root;
    }

    static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentnode = queue.poll();
            System.out.print(currentnode.val+ " ");
            if (currentnode.left != null) {
                queue.add(currentnode.left);
            }
            if (currentnode.right != null) {
                queue.add(currentnode.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1};
        int[] postorder = {1};
        TreeNode root = constructFromPrePost(preorder, postorder);
        levelOrderTraversal(root);
    }
}
