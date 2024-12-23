import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AveragesOfLevelInBinaryTree {
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
    public static int[] avgOfLevels(Node root){
        if(root == null) return new int[0];
        int[] res = new int[0];
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                Node node = q.poll();
                sum += node.data;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            res = Arrays.copyOf(res, res.length+1);
            res[res.length-1] = sum/size;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node newNode = createTree(sc);
        int[] result = avgOfLevels(newNode);

        for(int avg : result){
            System.out.print(avg+" ");
        }
        sc.close();
    }

}
