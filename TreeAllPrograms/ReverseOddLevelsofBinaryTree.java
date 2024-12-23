import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ReverseOddLevelsofBinaryTree {

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

    private static TreeNode reverseOddLevels(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        boolean lvl = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> nodes = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                nodes.add(temp);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(lvl){
                reverse(nodes);
            }
            lvl = !lvl;
        }
        return root;
    }

    static void reverse(List<TreeNode> nodes){
        int s = 0;
        int ed = nodes.size();
        while(s < ed){
            int temp = nodes.get(s).data;
            nodes.get(s).data = nodes.get(ed-1).data;
            nodes.get(ed-1).data = temp;
            s++;
            ed--;
        }
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }

        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data : ");
        TreeNode root = builTreeNode(sc);
        printTree(root);
        reverseOddLevels(root);
        System.out.println();
        printTree(root);
    }
}
