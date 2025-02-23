import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class RecoveraTreeFromPreorderTraversal {

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

    public static int getValue(String s,int n,int[] pos){
        int val =0;
        while(pos[0]<n && Character.isDigit(s.charAt(pos[0]))){
            val = val*10+(s.charAt(pos[0])-'0');
            pos[0]++;
        }
        return val;
    }

    public static int getNumberOfDasher(String s, int n, int[] pos){
        int cnt =0;
        while(pos[0]<n && s.charAt(pos[0])=='-'){
            cnt++;
            pos[0]++;
        }
        return cnt;
    }

    public static void buildTree(String s, TreeNode curr, int exptDashes, int n, int[] pos){
        if(pos[0]>n){
            return;
        }
        int prev = pos[0];
        int dashes = getNumberOfDasher(s, n, pos);
        if(dashes<exptDashes){
            pos[0] = prev;
            return;
        }

        TreeNode newNode = new TreeNode(getValue(s, n, pos));
        if(curr.left == null){
            curr.left = newNode;
        }
        else{
            curr.right = newNode;
        }
        buildTree(s, newNode, exptDashes+1, n, pos);
        buildTree(s, newNode, exptDashes+1, n, pos);
    }

    public static TreeNode recoverTreeRoot(String s){
        int n = s.length();
        int[] pos = {0};
        TreeNode root = new TreeNode(getValue(s,n,pos));
        buildTree(s,root,1,n,pos);
        buildTree(s,root,1,n,pos);
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
        Scanner sc = new Scanner(System.in);
        String s = sc.next();     //"1-401--349---90--88"
        sc.close();
        TreeNode root = recoverTreeRoot(s);
        levelOrderTraversal(root);

    }
}
