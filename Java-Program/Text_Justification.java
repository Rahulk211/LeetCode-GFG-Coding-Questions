import java.util.ArrayList;
import java.util.List;

public class Text_Justification {

    public static List<String> fullJustify(String[] words, int maxWidth){
        List<String> lines = new ArrayList<>();

        int index = 0 ;
        while(index < words.length){
            int cnt = words[index].length();
            int last = index+1;
            while(last<words.length){
                if(cnt+1+words[last].length() > maxWidth) break;
                cnt += 1+words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last-index-1;

            if(last == words.length || diff==0){
                for(int i =index+1;i<last;i++){
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for(int i=sb.length();i<maxWidth;i++){
                    sb.append(" ");
                }
            }else{
                int space = (maxWidth-cnt)/diff;
                int exspace = (maxWidth-cnt) % diff;
                for(int i = index+1;i<last;i++){
                    for(int j=space;j>0;j--){
                        sb.append(" ");
                    }
                    if(exspace>0){
                        sb.append(" ");
                        exspace--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification"};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }
    
}
