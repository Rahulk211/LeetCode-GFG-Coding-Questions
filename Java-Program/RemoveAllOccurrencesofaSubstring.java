public class RemoveAllOccurrencesofaSubstring {
    public static String removeOccurrences(String s, String part) {

        //int n = s.length();
        int index = s.indexOf(part);
        while (index != -1) {
            s = s.substring(0, index) + s.substring(index + part.length());
            //n = s.length();
            index = s.indexOf(part);
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences(s, part));
    }
}
