// import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class KthSmallestElementInBST {

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

    public static void printTreeInOrder(TreeNode root){
        if(root==null){
            return;
        }

        printTreeInOrder(root.left);
        System.out.print(root.data+" ");
        printTreeInOrder(root.right);

    }

    //static List<Integer> list = new ArrayList<>();
    static int ans=0;
    static int i=0;
    public static int KthSmallest(TreeNode root,int k){
        if(root==null){
            return 0;
        }
        getSmallest(root , k);
        return ans;
    }

    public static void getSmallest(TreeNode root, int k){
        if(root==null){
            return;
        }

        getSmallest(root.left,k);
        i++;
        if(i==k){
            ans = root.data;
            return;
        }
        getSmallest(root.right,k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k =3;
        TreeNode root = buildTree(sc);

        printTreeInOrder(root);
        System.out.println();

        Integer smallest = KthSmallest(root, k);
        System.out.println(smallest);



        
    }
}