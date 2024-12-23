import java.util.Arrays;

public class DividePlayersIntoTeamsofEqualSkill {

    public static int dividePlayers(int[] skills){
        int n = skills.length;
        Arrays.sort(skills);
        int chemistry_sum = 0;
        int total_skills = skills[0]+skills[n-1];

        for(int i=0;i<n/2;i++){
            if(skills[i]+skills[n-i-1] != total_skills){
                return -1;
            }
            else{
                chemistry_sum += skills[i]*skills[n-i-1];
            }
        }

        return chemistry_sum;
    }
    public static void main(String[] args) {
        int[] skills = {3,2,5,1,3,4};

        System.out.println("chemistry of all teams : " + dividePlayers(skills));
    }
}
