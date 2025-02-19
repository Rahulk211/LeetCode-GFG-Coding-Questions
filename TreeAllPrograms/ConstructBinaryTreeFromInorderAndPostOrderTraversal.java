import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
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

    private static TreeNode buildTree(int[] inorder,int[] postorder){
        if(inorder.length == 0 || postorder.length == 0) return null;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root = buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);

        return root;
    }

    private static TreeNode buildTree(int[] p,int pst,int pend,int[] in, int inst,int inend,Map<Integer,Integer> mp){
        if(pst>pend || inst>inend){
            return null;
        }

        TreeNode root = new TreeNode(p[pend]);
        int inroot = mp.get(root.val);
        int rl = inroot-inst;
        
        root.left = buildTree(p, pst, pst+rl-1, in, inst, inroot-1, mp);
        root.right = buildTree(p, pst+rl, pend-1, in, inroot+1, inend, mp);

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
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of postorder and inorder array");
        int n = sc.nextInt();
        int[] inorder = new int[n];
        int[] postorder = new int[n];
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            postorder[i]=sc.nextInt();
        }
        sc.close();
        TreeNode root = buildTree(inorder, postorder);
        printTreeInOrder(root);
    }
}
