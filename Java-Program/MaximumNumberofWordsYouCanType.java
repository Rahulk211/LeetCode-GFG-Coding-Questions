public class MaximumNumberofWordsYouCanType {

    private static int canBeTypedWords(String text, String bl){
        int n = bl.length();
        int cnt = 0;
        String[] words = text.split(" ");
        for( String w: words){
            boolean canType = true;
            for(int i=0; i<n; i++){
                if(w.indexOf(bl.charAt(i)) != -1){
                    canType = false;
                    break;
                }
            }
            if(canType) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        String text = "leet code", brokenLetters = "lt";
        System.out.println(canBeTypedWords(text, brokenLetters));
    }
}
