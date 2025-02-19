/*
515. Find Largest Value in Each Tree Row

Given the root of a binary tree, return an array of the largest value
in each row of the tree (0-indexed). */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class FindLargestValueinEachTreeRow {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static TreeNode builTreeNode(Scanner sc){
        int data = sc.nextInt();
        if(data < 0){
            return null;
        }

        TreeNode root = new TreeNode(data);
        System.out.print("Enter data left to " + data + " : ");
        root.left = builTreeNode(sc);
        System.out.print("Enter data right to " + data + " : ");
        root.right = builTreeNode(sc);

        return root;
    }

     public static List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                max = Math.max(max,temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            result.add(max);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        TreeNode root = builTreeNode(sc);
        List<Integer> ans = largestValues(root);
        System.out.println(ans);
    }
    
}
