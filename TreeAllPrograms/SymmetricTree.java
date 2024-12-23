import java.util.Scanner;

public class SymmetricTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node creatNode(Scanner sc){
        System.out.println("enter data");
        int data = sc.nextInt();

        if(data == -1){
            return null;
        }

        Node newnode = new Node(data);
        System.out.println("Enter left child of "+data);
        newnode.left = creatNode(sc);
        System.out.println("Enter right child of "+data);
        newnode.right = creatNode(sc);

        return newnode;
    }

    public static void printTree(Node root){
        if(root == null){
            return;
        }

        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }

    public static boolean isSymmetry(Node root){
        if(root == null){
            return true;
        }

        return isSymmetryhelp(root.left,root.right);
    }

    public static boolean isSymmetryhelp(Node left,Node right){
        if(left == null && right == null){
            return true;
        }

        if(left.data !=right.data){
            return false;
        }

        return isSymmetryhelp(left.left, right.right) && isSymmetryhelp(left.right , right.left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = creatNode(sc);
        printTree(root);
        System.out.println(" the is Symmetric: -"+isSymmetry(root));

        sc.close();
    }
}
