// Given a list of folders folder, return the folders after removing all sub-folders in those folders. 
// You may return the answer in any order.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveSubFoldersfromtheFilesystem {

    private static List<String> removeSubfolders(String[] str){
        int n =str.length;
        List<String> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            String path = str[i];
            System.out.println(path);

        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of string arr : ");
        int n = sc.nextInt();
        String[] str = new String[n];
        System.out.println("Enter the path of folders");
        for(int i=0;i<n;i++){
            str[i] = sc.next();
        }
        sc.close();
        removeSubfolders(str);
    }
    
}
