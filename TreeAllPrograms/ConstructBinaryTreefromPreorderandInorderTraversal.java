import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        /* constructor of node class used to assign the value */
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(int[] pre,int[] in){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }

        TreeNode root = buildTree(pre,0,pre.length-1,in, 0,in.length-1,map);

        return root;

    }

    public static TreeNode buildTree(int[] p, int pst,int pend,int[] in, int nst,int nend, Map<Integer,Integer> mp){
        if(pst>pend||nst>nend){
            return null;
        }

        TreeNode root = new TreeNode(p[pst]);

        int inroot = mp.get(root.data);
        int numsleft = inroot-nst;

        root.left = buildTree(p,pst+1,pst+numsleft,in,nst,inroot-1,mp);
        root.right = buildTree(p,pst+numsleft+1,pend,in,inroot+1,nend,mp);

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            inorder[i]=sc.nextInt();
        }
        TreeNode root = buildTree(preorder, inorder);
        sc.close();
        printTreeInOrder(root);
        
    }
}
