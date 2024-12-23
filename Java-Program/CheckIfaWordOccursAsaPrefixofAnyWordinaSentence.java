public class CheckIfaWordOccursAsaPrefixofAnyWordinaSentence {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] word = sentence.trim().split(" ");

        for(int i=0;i<word.length;i++){
            if(isPrefix(word[i],searchWord)){
                return i+1;
            }
        }
        return -1;
    }

    private static boolean isPrefix(String word, String pre){
        if(word.length()<pre.length()){
            return false;
        }
        for(int i=0;i<pre.length();i++){
            if(pre.charAt(i)!=word.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String sentence = "this problem is an easy problem", searchWord = "pro";
        System.out.println(isPrefixOfWord(sentence,searchWord));
    }
}
