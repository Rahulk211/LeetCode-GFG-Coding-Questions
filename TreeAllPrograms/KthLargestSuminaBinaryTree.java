import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class KthLargestSuminaBinaryTree {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(Scanner sc){
        System.out.println("enter data");
        int data = sc.nextInt();

        if(data < 0){
            return null;
        }

        TreeNode root = new TreeNode(data);

        System.out.println("Enter left of " + data);
        root.left = buildTree(sc);
        System.out.println("Enter right of " + data);
        root.right = buildTree(sc);
        
        return root;
    }

    private static long kthLargestLevelSum(TreeNode root,int k){
        if(root == null) return 0;

        List<Long> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            long sum = 0;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                //System.out.println(node.data+" ");
                sum += node.data;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res.add(sum);
        }
        Collections.sort(res,Collections.reverseOrder());

        return res.size() >= k? res.get(k-1):0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc);

        System.out.print("Enter the value of k : ");
        int k = sc.nextInt();
        System.out.println(kthLargestLevelSum(root, k));

    }
}
