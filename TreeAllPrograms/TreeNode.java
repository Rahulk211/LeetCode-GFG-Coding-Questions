import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode() {
        //TODO Auto-generated constructor stub
    }

    public TreeNode buildTree(Scanner sc){
        int data = sc.nextInt();
        if(data < 0){
            return null;
        }

        TreeNode root = new TreeNode(data);
        System.out.print("Enter data left to " + data + " : ");
        root.left = buildTree(sc);
        System.out.print("Enter data right to " + data + " : ");
        root.right = buildTree(sc);

        return root;
    }

    public void printTree(TreeNode root){
        if(root==null){
            return;
        }

        printTree(root.left);
        System.out.print(root.val+" ");
        printTree(root.right);
    }
}

    
