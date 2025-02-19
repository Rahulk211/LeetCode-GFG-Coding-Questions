// class Node{
//     Node links[];
//     boolean flag;

//     Node(){
//         links = new Node[26];
//         flag = true;
//     }

//     public boolean containsKey(char ch){
//         return (links[ch-'a']!=null);
//     }

//     public Node get(char ch){
//         return links[ch-'a'];
//     }

//     public void put(char ch, Node node){
//         links[ch-'a'] = node;
//     }

//     public void setEnd(){
//         flag = true;
//     }

//     public boolean isEnd(){
//         return flag;
//     }
// }

public class DesignAddandSearchWordsDataStructure {
    class Node {
        Node[] links = new Node[26];
        boolean flag;

        public Node() {
            links = new Node[26];
            flag = false;
        }
    }

    static Node root;

    public DesignAddandSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            Node curr = node.links[word.charAt(i)-'a'];
            if (curr == null) {
                node.links[word.charAt(i)-'a'] = new Node();
                curr = node.links[word.charAt(i)-'a'];
            }
            node = curr;
        }
        node.flag = true;
    }

    public boolean search(String word) {
        return find(0, word, root);
    }

    public static boolean find(int idx, String word, Node root) {
        if (idx == word.length()) {
            // If we have reached the end of the word, check if the current node is a valid
            // word
            return root.flag;
        }

        char currentChar = word.charAt(idx);

        if (currentChar == '.') {
            // If the character is a wildcard, check all 26 possibilities
            for (int i = 0; i < 26; i++) {
                if (root.links[i] != null && find(idx + 1, word, root.links[i])) {
                    return true;
                }
            }
            return false; // If no valid match found after checking all possible letters
        }

        // Otherwise, handle the specific character case
        if (root.links[currentChar - 'a'] != null) {
            return find(idx + 1, word, root.links[currentChar - 'a']);
        }

        return false; // If no match found
    }

    public static void main(String[] args) {
        DesignAddandSearchWordsDataStructure dataStructure = new DesignAddandSearchWordsDataStructure();
        dataStructure.addWord("bad");
        dataStructure.addWord("dad");
        dataStructure.addWord("mad");
        System.out.println(dataStructure.search("pad"));  // returns False
        System.out.println(dataStructure.search("bad"));  // returns True
        System.out.println(dataStructure.search("ba."));  // returns True
        System.out.println(dataStructure.search("..d"));  // returns True
        System.out.println(dataStructure.search(".a."));  // returns True
        
    }

}
