import java.util.Scanner;


public class LongestZigZagPathinaBinaryTree {
    
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left =null;
            this.right = null;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
        System.out.println(longestZigZag(root));
    }

    static int pathlen;
    public static int longestZigZag(TreeNode root){
        pathlen = 0;
        maxZigZag(root.left, 1,1);
        maxZigZag(root.right,1,0);

        return pathlen;
    }

    private static void maxZigZag(TreeNode node,int cnt, int dir){
        if(node == null) return ;

        pathlen = Math.max(pathlen,cnt);
        if(dir == 0){
            maxZigZag(node.left, cnt+1, 1);
            maxZigZag(node.right, 1, 0);
        }
        else{
            maxZigZag(node.right, cnt+1, 0);
            maxZigZag(node.left, 1, 1);
        }
    }
}

    
