import java.util.Scanner;

public class MinimumNumberofSecondstoMakeMountainHeightZero {

    private static long minNumberOfSeconds(int mountainHeight, int[] workerTimes){
        int n = workerTimes.length;
        long res = 0;
        int Tmax=0;

        for(int i=0;i<n;i++){
            Tmax = Tmax < workerTimes[i] ? workerTimes[i] : Tmax;
        }

        long l=1, r = (long)Tmax*mountainHeight*(mountainHeight + 1)/2;

        while(l<=r){
            long mid = l + (r-l) / 2;
            
            if(check(mountainHeight, workerTimes, mid)){
                res = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return res;
    }

    private static boolean check(int mh, int[] workerTimes, long mid){
        long hts=0;
        for(int t : workerTimes){
            long ht =  (long)(Math.sqrt(2.0*mid/t + 0.25) - 0.5);
            hts += ht;
        }

        if(hts >= mh )  return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mountainHeight = sc.nextInt();

        System.out.println("Enter the size of the workerTimes array - ");
        int n = sc.nextInt();
        int[] workerTimes = new int[n];

        for(int i=0;i<n;i++){
            System.out.println("Enter the time in seconds in workerimes array - ");
            workerTimes[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Min time required is - " + minNumberOfSeconds(mountainHeight, workerTimes));
    }
}
