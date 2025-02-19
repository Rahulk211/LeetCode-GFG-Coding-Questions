// givan a string that represent a dna sequence return all the 10 letter long sequence that accour more then once in a dna molecule
// you may return answer in any order.
//example str = {"aaaabbbbaaabbbbaaaa"}
// output aaaabbbb,bbbbaaaa

import java.util.HashMap;
import java.util.Scanner;

public class DnaSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dna sequence : ");
        String str = sc.nextLine();

        sc.close();
        
        if(str.length()<10){
            System.out.println("The sequence is too short");
            System.exit(0);
        }
        
        HashMap<String,Integer> smp=new HashMap<>();

        for(int i=0;i<str.length()-10;i++){
            String sub= str.substring(i, i+10);
            if(smp.containsKey(sub)){
                smp.put(sub, smp.get(sub)+1);
            }
            else{
                smp.put(sub, 1);
            }
            
        }


    }
    
}
