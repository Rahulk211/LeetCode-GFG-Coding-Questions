import java.util.Scanner;

public class HeightofBinaryTreeAfterSubtreeRemovalQueries {
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

    static int max;
    private static int[] treeQueries(TreeNode root, int[] queies){
        if(root == null){
            return new int[]{};
        }
        int[] left = new int[100001];
        int[] right = new int[100001];
        max = 0;
        leftDepth(root, left, 0);
        max = 0;
        rightDepth(root, right, 0);
        
        for(int i=0;i<queies.length;i++){
            queies[i] = Math.max(left[queies[i]],right[queies[i]]);
        }

        return queies;
    }
    private static void leftDepth(TreeNode root, int[] left, int d){
        if (root == null) {
            return;
        }
        left[root.data] = max;
        max = Math.max(max,d);
        leftDepth(root.left, left, d + 1);
        leftDepth(root.right, left, d + 1);
    }

    private static void rightDepth(TreeNode root, int[] right, int d){
        if (root == null) {
            return;
        }
        right[root.data] = max;
        max = Math.max(max,d);
        rightDepth(root.right, right, d + 1);
        rightDepth(root.left, right, d + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data : ");
        TreeNode root = builTreeNode(sc);
        System.out.print("Enter size of queies array : ");
        int n = sc.nextInt();
        int[] queies = new int[n];
        for(int i=0;i<n;i++){
            queies[i]=sc.nextInt();
        }
        
        int[] res = treeQueries(root, queies);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");            
        }
    }
    
}
