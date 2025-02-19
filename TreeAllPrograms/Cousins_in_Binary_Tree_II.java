import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Cousins_in_Binary_Tree_II {

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

    private static TreeNode replaceValueInTree(TreeNode root){
        if(root == null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        q.offer(root);
        //Pass-01
        while(!q.isEmpty()){
            int sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                //System.out.println(node.data+" ");
                sum += node.data;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            list.add(sum);
        }

        //Pass-02
        q.offer(root);
        int lvl =0;
        root.data = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                int sum=0;
                if(node.left != null) {
                    sum +=node.left.data;
                }
                if(node.right != null) {
                    sum +=node.right.data;
                }
                if(node.left != null) {
                    node.left.data = list.get(lvl+1) - sum;
                    q.add(node.left);
                }
                if(node.right != null) {
                    node.right.data = list.get(lvl+1) - sum;
                    q.add(node.right);
                }
            }
            lvl++;
        }

        return root;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        TreeNode root = builTreeNode(sc);
        System.out.println("Inorder Traversal of the tree is : ");
        inordertraversal(root);

        TreeNode newRoot = replaceValueInTree(root);
        System.out.println("Inorder Traversal of the new tree is : ");
        inordertraversal(newRoot);


    }
    
}
