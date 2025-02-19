import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public static List<List<Integer>> zigzagLevelOrderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // int level=0;

        // while(!queue.isEmpty()){
            
        //     List<Integer> l = new ArrayList<>();
        //     int levelsize = queue.size();

        //     for(int i=0;i<levelsize;i++){
        //         TreeNode curr = queue.poll();
        //         l.add(curr.data);

        //         if(level % 2 == 0){
        //             if(curr.left != null) queue.offer(curr.left);
        //             if(curr.right != null) queue.offer(curr.right);
        //         }
        //         else{
        //             if(curr.right != null) queue.offer(curr.right);
        //             if(curr.left != null) queue.offer(curr.left);
        //         }
        //     }
        //     list.add(l);
        //     level++;
        //}

        boolean ltor=true;
        while(!queue.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                l.add(curr.data);

                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }

            if(!ltor){
                Collections.reverse(l);
            }
            list.add(l);
            ltor=!ltor;
        }
        return list;  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);

        List<List<Integer>> result = zigzagLevelOrderTraversal(root);
        System.out.println(result);
    }
}
