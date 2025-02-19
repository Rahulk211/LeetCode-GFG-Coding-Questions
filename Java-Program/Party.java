import java.util.Scanner;

public class Party {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int ent[]={7,0,5,1,3};
        int lev[]={1,2,1,3,4};
        int sum=0,max=0;
        for(int i=0;i<ent.length;i++){
            sum+=ent[i];
            sum-=lev[i];
            max=Math.max(max,sum);
        }
        System.out.println("The maximun number of guest are:- "+max);
        sc.close();
    }
}
