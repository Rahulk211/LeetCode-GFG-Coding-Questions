public class TakeKofEachCharacterFromLeftandRight {

    private static int takeCharacters(String s, int k){
        int n=s.length();
        int left = 0;
        int[] freq = new int[3];
        while(left<n && (freq[0]<k ||freq[1]<k || freq[2]<k)){
            freq[s.charAt(left)-'a']++;
            left++;
        }
        if(freq[0]<k ||freq[1]<k || freq[2]<k){
            return -1;
        }
        int minimum_time =left;
        left -= 1;
        int right = n-1;


        while(left >=0 ){
            freq[s.charAt(left)-'a']--;
            left--;

            while(left<=right && (freq[0]<k ||freq[1]<k || freq[2]<k)){
                freq[s.charAt(right)-'a']++;
                right--;
            }
            minimum_time = Math.min(minimum_time, n-(right-left));
        } 

        return minimum_time;
    }
    public static void main(String[] args) {
        String str = "aabaaaaaacaabac";
        int k = 2;
        System.out.println(takeCharacters(str, k));
    }
}
