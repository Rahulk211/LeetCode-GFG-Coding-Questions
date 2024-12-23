import java.util.Scanner;

public class SumRoottoLeafNumbers {
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

    public static TreeNode createTree(Scanner sc){
        System.out.print("Enter data: - ");
        int data =sc.nextInt();

        if(data == -1){
            return null;
        }

        TreeNode root = new TreeNode(data);

        System.out.println("Enter left of data "+ data+": - ");
        root.left = createTree(sc);
        System.out.println("Enter right of data "+data+": - ");
        root.right = createTree(sc);

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

    public static int sumRoottoLeaf(TreeNode root,int sum){
        if(root == null){
            return 0;
        }
        sum = sum*10+root.data;
        if(root.left == null && root.right == null){
            return sum;
        }

        return sumRoottoLeaf(root.left, sum)+sumRoottoLeaf(root.right, sum);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = createTree(sc);

        sc.close();

        printTreeInOrder(root);
        System.out.println("\nSum of root to leaf nodes: "+sumRoottoLeaf(root,0));
    }
}
