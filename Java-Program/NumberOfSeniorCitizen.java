public class NumberOfSeniorCitizen {

    public static void main(String[] args) {
        String[] d={"7016087641M7522","7016087641M7922","7016087641M4522"};
        int count = 0;
        int n=d.length;
        for(int i=0;i<n;i++){
            String st=d[i];
            if(st.charAt(11)>'6' && st.charAt(12)>'0'){
                System.out.println(st.charAt(11));
                count++;
            }
        }
        System.out.println(count);
    }
}