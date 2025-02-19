class TrieNode {
    TrieNode[] links;
    boolean flag ;

    public TrieNode(){
        links = new TrieNode[26];
        flag = false;
    }

    public boolean containsKey(char ch){
        return (links[ch-'a'] != null);
    }

    public TrieNode get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode node){
        links[ch-'a'] = node;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}

public class TrieImplementation {
    static TrieNode root;

    public TrieImplementation(){
        root = new TrieNode();
    }

    public static void insert(String word){
        if(word == null || word.isEmpty()){
            return ;
        }
        
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new TrieNode());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
        System.out.println("Inserted word: " + word);
    }

    public static boolean search(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        if(node.isEnd()){
            return true;
        }
        return false;
    }

    public static boolean startsWith(String prefix){
        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        insert("apple");
        insert("apps");
        insert("abcas");
        insert("bikes");
        insert("cars");
        System.out.println(search("apple"));
        System.out.println(search("bike"));
        System.out.println(search("appi"));
        System.out.println(startsWith("ap"));
        System.out.println(startsWith("bik"));
        System.out.println(startsWith("crs"));
    }
}
