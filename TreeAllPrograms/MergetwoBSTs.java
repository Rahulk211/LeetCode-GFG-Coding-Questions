import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import javax.swing.tree.TreeNode;

public class MergetwoBSTs {

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

    public static Node buildTree(Scanner sc){
        System.out.println("Enter data");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        root.left = buildTree(sc);
        root.right = buildTree(sc);

        return root;
    }

    private static List<Integer> merge(Node root1, Node root2){
        if(root1==null && root2 == null){
            return null;
        }
        
        List<Integer> l1 = inOrder(root1, new ArrayList<>());
        List<Integer> l2 = inOrder(root2, new ArrayList<>());

        // System.out.println(l1);
        // System.out.println(l2);
        List<Integer> merged = new ArrayList<>();
        while(!l1.isEmpty() && !l2.isEmpty()){
            if(l1.get(0) < l2.get(0)){
                merged.add(l1.get(0));
                l1.remove(0);
            }
            else{
                merged.add(l2.get(0));
                l2.remove(0);
            }
        }
        while(!l1.isEmpty()){
            merged.add(l1.get(0));
            l1.remove(0);
        }
        while(!l2.isEmpty()){
            merged.add(l2.get(0));
            l2.remove(0);
        }

        return merged;
    }

    private static List<Integer> inOrder(Node root, List<Integer> inorder){
        if(root == null){
            return null;
        }
        
        inOrder(root.left, inorder);
        inorder.add(root.data);
        inOrder(root.right, inorder);
        
        return inorder;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root1 = buildTree(sc);
        Node root2 = buildTree(sc);
        List<Integer> merged = merge(root1, root2);
        System.out.println(merged);
        
    }
}