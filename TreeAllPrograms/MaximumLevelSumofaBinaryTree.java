import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumLevelSumofaBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode buildTreeNode(Scanner sc) {
        System.out.print("Does node exist? (true/false): ");
        boolean exists = sc.nextBoolean();

        if (!exists) {
            return null;
        }

        System.out.print("Enter node data: ");
        int data = sc.nextInt();

        TreeNode root = new TreeNode(data);

        System.out.print("Enter left of " + data + " : ");
        root.left = buildTreeNode(sc);

        System.out.print("Enter right of " + data + " : ");
        root.right = buildTreeNode(sc);

        return root;
    }

    private static int maxLevelSum(TreeNode root) {
        if (root == null)
            return -1;
        if (root.right == null && root.left == null)
            return 1;

        int minlevel = 0;
        int currlevel = 0;
        int maxsum = Integer.MIN_VALUE;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int curr_sum = 0;
            currlevel++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                curr_sum += node.data;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if (curr_sum > maxsum) {
                minlevel = currlevel;
                maxsum = curr_sum;
            }
        }

        return minlevel;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTreeNode(sc);

        System.out.println(maxLevelSum(root));
    }
}
