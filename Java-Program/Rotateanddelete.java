/*
 * Given an array arr integers. Assume sz to be the initial size of the array.
 *  Do the following operations exactly sz/2 times. In every kth (1<= k <= sz/2) operation:
 * Right-rotate the array clockwise by 1.
 * Delete the (n– k + 1)th element from begin.
 * Now, Return the first element of the array.
 */


import java.util.ArrayList;
import java.util.Collections;

public class Rotateanddelete {

    private static int rotateDelete(ArrayList<Integer> list){
        int n = list.size();
        for (int k = 1; k <= n / 2; k++) {
            // Right-rotate the array clockwise by 1
            Collections.rotate(list, 1);
            // Delete the (n– k + 1)th element from end
            if (k == 1) {
                list.remove(list.size() - 1);
            } else if (k == 2) {
                list.remove(list.size() - 2);
            } else {
                list.remove(0);
            }
        }

        return list.get(0);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<7;i++){
            list.add(i);
            System.out.println(i);
        }
        System.out.println(rotateDelete(list));
    }
    
}
