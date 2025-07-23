import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeleteDuplicateFoldersinSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> paths = new ArrayList<>();
        System.out.println("Enter no. of paths");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            paths.add(new ArrayList<String>());
        }
        for(int i=0;i<n;i++){
            System.out.println("Enter length of string at "+i+"th path");
            int m = sc.nextInt();
            for(int j=0;j<m;j++){
                System.out.println("Enter string char "+j+"th in list");
                String s = sc.next();
                paths.get(i).add(s);
            }
        }
        sc.close();

        Solution obj = new Solution();

        System.out.println(obj.deleteDuplicateFolder(paths));
    }
}

class Solution{

    static class trieNode{
        String folder;
        boolean rem;
        Map<String, trieNode> map;

        public trieNode(String folder){
            this.folder = folder;
            this.rem = false;
            map = new HashMap<>();
        }
    }

    static void trieInsert(trieNode root, List<String> paths){
        for(String s : paths){
            if(!root.map.containsKey(s)){
                root.map.put(s, new trieNode(s));
            }

            root = root.map.get(s);
        }
    }

    public static String markRepeatingNode(trieNode root, Map<String, trieNode> visited){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, trieNode> entry : root.map.entrySet()){
            sb.append(markRepeatingNode(entry.getValue(), visited));
        }

        if(sb.length() > 0){
            String key = "[" + root.folder + sb.toString() +"]";
            if(visited.containsKey(key)){

                visited.get(key).rem = true;
                root.rem = true;
            }
            else{
                visited.put(key, root);
            }
            return key;
        }

        return "[" + root.folder + "]";
    }

    public static void savePaths(trieNode root, List<String> curr, List<List<String>> res){
        if(root.rem){
            return;
        }

        curr.add(root.folder);
        res.add(new ArrayList<>(curr));
        for(Map.Entry<String, trieNode> entry : root.map.entrySet()){
            savePaths(entry.getValue(), curr, res);
        }
        curr.remove(curr.size() - 1);


    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths){
        // step 1: insert folder into trie..
        trieNode root = new trieNode("/");
        for(List<String> path: paths){
            trieInsert(root, path);
        } 

        // Step 2: mark nodes to be removed
        Map<String, trieNode> vis = new HashMap<>();
        markRepeatingNode(root, vis);

        // step 3: save the path after deletion
        List<List<String>> res = new ArrayList<>();
        List<String> currpath = new ArrayList<>();
        for(Map.Entry<String, trieNode> entry : root.map.entrySet()){
            savePaths(entry.getValue(), currpath, res);
        }

        return res;
    }
}