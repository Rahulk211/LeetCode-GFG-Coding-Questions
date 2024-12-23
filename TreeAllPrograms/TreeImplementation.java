// Binary tree implementation in java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pair{
    int height;
    int diameter;
}

public class TreeImplementation {
    /*
     * class node works as a structure of c language and it help to create the
     * structure of tree
     */
    private static class Node {
        int data;
        Node left;
        Node right;

        /* constructor of node class used to assign the value */
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /*
     * class tree is used to create the tree and it is the main class of tree
     * implementation.
     * Scanner class object is pass in this to get data from the user and create a
     * node for that data
     */

    static Node createTree(Scanner sc) {
        System.out.println("Enter data :");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        Node node = new Node(data);

        System.out.println("Enter the left child of" + data);
        node.left = createTree(sc);

        System.out.println("Enter the right child of" + data);
        node.right = createTree(sc);

        return node;
    }

    // Inorder traversal of tree.
    static void inOrder(Node root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // preorder traversal of tree.
    static void preOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // postorder traversal of tree.
    static void postOrder(Node root) {

        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    static int NumberOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return NumberOfNodes(root.left) + NumberOfNodes(root.right) + 1;
    }

    static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        }

        return sumOfNode(root.left) + sumOfNode(root.right) + root.data;
    }

    static int maxNode(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(root.data, Math.max(maxNode(root.left), maxNode(root.right)));
    }

    static int minNode(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(minNode(root.left), minNode(root.right)));
    }

    static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max((heightOfTree(root.left) + 1), (heightOfTree(root.right) + 1));
    }

    static void leafNode(Node root) {
        if (root == null) {
            return;
        }
        leafNode(root.left);
        leafNode(root.right);
        if (root.left == null && root.right == null) {
            System.out.println("leaf node :-" + root.data);
        }

    }

    static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentnode = queue.poll();
            System.out.print(currentnode.data + " ");
            if (currentnode.left != null) {
                queue.add(currentnode.left);
            }
            if (currentnode.right != null) {
                queue.add(currentnode.right);
            }
        }
    }

    static void printLeftView(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {

            list.add(root);
        }

        printLeftView(root.left, list, level + 1);
        printLeftView(root.right, list, level + 1);
    }

    static void leftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();
        printLeftView(root, list, 0);
        for (Node cur : list) {
            System.out.println(cur.data);
        }
    }

    static void printRightView(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(root);
        }

        printRightView(root.right, list, level + 1);
        printRightView(root.left, list, level + 1);
    }

    static void rightView(Node root) {
        ArrayList<Node> listr = new ArrayList<>();
        printRightView(root, listr, 0);
        for (Node cur : listr) {
            System.out.println(cur.data);
        }
    }

    static Node removeLeafNodes(Node root) {
        if (root == null) {
            return null ;
        }
        if (root.left == null && root.right == null) {
            //System.out.println("Remove element is : " + root.data);
            return null;
        }
        root.left=removeLeafNodes(root.left);
        root.right=removeLeafNodes(root.right);

        return root;
    }
    /*Diameter of tree */
    static pair diameterOfTree(Node root) {
        if (root == null) {
            return null;
        }
        pair left = diameterOfTree(root.left);
        pair right = diameterOfTree(root.right);

        pair mypair = new pair();

        mypair.height=Math.max(left.height, right.height)+1;
        int curdiameter=left.diameter+right.diameter+2;

        mypair.diameter=Math.max(Math.max(left.diameter,right.diameter),curdiameter);
        
        return mypair;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node newNode = createTree(sc);
        //pair mypair = diameterOfTree(newNode);
    
        int option;
        do {
            System.out.println("\n1. Tree traversal");
            System.out.println("\n2. Left view of tree");
            System.out.println("\n3. Right view of tree");
            System.out.println("\n4. Height of tree");
            System.out.println("\n5. Sizee of tree");
            System.out.println("\n6. Maximum element of tree");
            System.out.println("\n7. Minimum element of tree");
            System.out.println("\n8. Leaf node of tree");
            System.out.println("\n9. Level order traversal of tree");
            System.out.println("\n10. Sum of all node of tree");
            System.out.println("\n11. Remove leaf element form tree");
            System.out.println("\n12. Diameter of binary tree");
            System.out.println("\n0. Exit");
            System.out.println("\nEnter your choice: ");
            option = sc.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Inorder traversal");
                    inOrder(newNode);
                    System.out.println("");
                    System.out.println("Preorder traversal");
                    preOrder(newNode);
                    System.out.println("");
                    System.out.println("Postorder traversal");
                    postOrder(newNode);
                    break;

                case 2:
                    System.out.println("left view  of tree : ");
                    leftView(newNode);
                    break;

                case 3:
                    System.out.println("right view  of tree : ");
                    rightView(newNode);
                    break;

                case 4:
                    System.out.println("Height of tree is " + heightOfTree(newNode));
                    break;

                case 5:
                    System.out.println("Total number of nodes " + NumberOfNodes(newNode));
                    break;

                case 6:
                    System.out.println("Max element of array " + maxNode(newNode));
                    break;

                case 7:
                    System.out.println("Min element of array" + minNode(newNode));
                    break;

                case 8:
                    System.out.println("Leaf node of tree ");
                    leafNode(newNode);
                    break;

                case 9:
                    System.out.println("Level order traversal of tree ");
                    levelOrderTraversal(newNode);
                    break;

                case 10:
                    System.out.println("Sum of all node of tree " + sumOfNode(newNode));
                    break;

                case 11:
                    System.out.println("Removing the leaf element form tree......... ");
                    removeLeafNodes(newNode);
                    break;

                case 12:
                System.out.println("diameter of tree : "+diameterOfTree(newNode));    

                case 0:
                    System.out.println("Exiting Program .....");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}
