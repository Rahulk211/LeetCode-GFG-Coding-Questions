import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RankTransformofanArray {

    private int[] arrayRankTransform(int[] arr){
        int[] num = Arrays.copyOf(arr, arr.length);
        Arrays.sort(num);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num.length;i++){
            map.putIfAbsent(num[i],map.size()+1);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {40, 10, 30, 10};
        RankTransformofanArray obj = new RankTransformofanArray();
        int[] rank = obj.arrayRankTransform(arr);
        for(int n :rank){
            System.out.print(n+" ");
        }
    }
}
