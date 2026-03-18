import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreeRightSideView {

    private static List<Integer> rightSideView(TreeNode root){
        List<Integer> res = new ArrayList<>();
        viewRight(res, root, 0);

        return res;
    }

    private static void viewRight(List<Integer> res, TreeNode root, int level){
        if(root == null) return ;

        if(level == res.size()){
            res.add(root.val);
        }

        viewRight(res, root.right, level+1);
        viewRight(res, root.left, level+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode obj = new TreeNode();

        TreeNode root = obj.buildTree(sc);
        System.out.println(rightSideView(root));
    }
}
