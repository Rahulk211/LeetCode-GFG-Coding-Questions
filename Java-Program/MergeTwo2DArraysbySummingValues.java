import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwo2DArraysbySummingValues {

    private static int[][]  mergeArrays(int[][] nums1, int[][] nums2){
        int n=nums1.length;
        int m = nums2.length;
        
        Map<Integer,Integer> map = new HashMap<>();

        int i=0,j=0;

        while(i<n && j<m){
            if(nums1[i][0] == nums2[j][0]){
                map.put(nums1[i][0], nums1[i][1]+nums2[j][1]);
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                map.put(nums1[i][0],nums1[i][1]);
                i++;
            }
            else{
                map.put(nums2[j][0],nums2[j][1]);
                j++;
            }
        }
        while(i<n){
            map.put(nums1[i][0],nums1[i][1]);
            i++;
        }
        while(j<m){
            map.put(nums2[j][0],nums2[j][1]);
            j++;
        }
        
    //     for(int i=0;i<n;i++){
    //         map.put(nums1[i][0], nums1[i][1]);
    //     }

    //     for(int i=0;i<m;i++){
    //         int id = nums2[i][0];
    //         if(map.containsKey(id)){
    //             map.put(id,map.get(id)+nums2[i][1]);
    //         }
    //         else{
    //             map.put(id, nums2[i][1]);
    //         }
    //     }
        int size  = map.size();
        int[][] result = new int[size][2];
        int k=0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            result[k][0] = entry.getKey();
            result[k][1] = entry.getValue();
            k++;
        }

       Arrays.sort(result, (a,b) -> Integer.compare(a[0], b[0]));

        return result;
    }
    public static void main(String[] args) {
        int[][] nums1 = {{1,4},{2,3},{4,5}};
        int[][] nums2 = {{1,2},{3,2},{4,1}};

        int[][] result = mergeArrays(nums1,nums2);
        for(int i=0;i<result.length;i++){
            System.out.println("[" + result[i][0] + "," + result[i][1] + "]");
        }
    }
}
