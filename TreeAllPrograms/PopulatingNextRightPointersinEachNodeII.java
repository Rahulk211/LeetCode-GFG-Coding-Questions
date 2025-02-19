import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PopulatingNextRightPointersinEachNodeII {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int data){
            this.val = data;
            this.left = null;
            this.right = null;
            this.next = null;
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

    public static void printTreeInOrder(TreeNode root){
        if(root==null){
            return;
        }

        printTreeInOrder(root.left);
        System.out.print(root.val+" ");
        printTreeInOrder(root.right);

    }

    public static TreeNode connect(TreeNode root){
        if(root == null){
            return null;
        }
        root.next=null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode prev = null;
            for(int i=0;i<size;i++){
                TreeNode currnode = queue.poll();
                if(prev!=null){
                    prev.next = currnode;
                }
                prev = currnode;

                if(currnode.left!=null){
                    queue.offer(currnode.left);
                }
                if(currnode.right!=null){
                    queue.offer(currnode.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
        sc.close();
        printTreeInOrder(root);
    }
}
