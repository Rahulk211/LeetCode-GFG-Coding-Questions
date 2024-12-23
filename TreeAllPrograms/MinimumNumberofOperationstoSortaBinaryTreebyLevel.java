import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class MinimumNumberofOperationstoSortaBinaryTreebyLevel {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(){};
        // TreeNode(int data) {
        //     this.data = data;
        // }
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
    private static int  minimumOperations(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> nodes = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                nodes.add(temp.data);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            count += minSwaps(nodes);
        }
        return count;
    }

    private static int minSwaps(List<Integer> nodes){
        List<Integer> sorted = new ArrayList<>(nodes);
        Collections.sort(sorted);
        Map<Integer,Integer> pos = new HashMap<>();
        for(int i=0;i<sorted.size();i++){
            pos.put(sorted.get(i), i);
        }

        int i=0,swaps=0;
        while(i<nodes.size()){
            int idx = pos.get(nodes.get(i));
            if(idx == i) i++;
            else{
                int temp = nodes.get(i);
                nodes.set(i, nodes.get(idx));
                nodes.set(idx, temp);
                swaps++;
            }
        }
        return swaps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data : ");
        TreeNode root = builTreeNode(sc);
        System.out.println("Minimum number of operations to sort the binary tree by level is " +  minimumOperations(root));

    }
}
