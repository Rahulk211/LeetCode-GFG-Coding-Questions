// Given the root of a binary tree, invert the tree, and return its root.

 

import java.util.Scanner;

public class InvertBinaryTree {

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

    public static Node invertBinaryTree(Node root){
        if(root == null){
            return null;
        }
        else{
            Node left = invertBinaryTree(root.left);
            Node right = invertBinaryTree(root.right);
            root.left = right;
            root.right = left;
        }
        return root;
    }

    public static void inordertraversal(Node root){
        if(root == null){
            return;
        }
        inordertraversal(root.left);
        System.out.print(root.data +" ");
        inordertraversal(root.right);
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Node root = creatNode(sc);
        System.out.println("Inorder traversal of the original tree");
        inordertraversal(root);
        root = invertBinaryTree(root);
        System.out.println("\nInorder traversal of the inverted tree");
        inordertraversal(root);

        sc.close();
    }
    
}
