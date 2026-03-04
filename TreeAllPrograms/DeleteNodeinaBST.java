import java.util.Scanner;

public class DeleteNodeinaBST {

    private static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(root.val == key){
            return helper(root);
        }

        TreeNode dummy = root;
        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }

        return dummy;
    }

    private static TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }else if(root.right == null){
            return root.left;
        }
        else{
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    private static TreeNode findLastRight(TreeNode root){
        if(root.right == null){
            return root;
        }

        return findLastRight(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode obj = new TreeNode();
        TreeNode root = obj.buildTree(sc);
        int key = sc.nextInt();

        TreeNode node = deleteNode(root, key);
        obj.printTree(node);
    }
}
