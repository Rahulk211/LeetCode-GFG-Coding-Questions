import java.util.Scanner;

class solution {
    static long[] bal;

    public solution(long[] balance) {
        bal = balance;
    }

    public boolean transfer(int acc1, int acc2, long amt){
        if(acc1<1 || acc1>bal.length || acc2<1 || acc2>bal.length || bal[acc1-1]<amt) return false;
        bal[acc1-1]-=amt;
        bal[acc2-1]+=amt;
        return true;
    }

    public boolean deposit(int acc, long amt){
        if(acc<1 || acc>bal.length) return false;
        bal[acc-1]+=amt;
        return true;
    }

    public boolean withdraw(int acc, long amt){
        if(acc<1 || acc>bal.length || bal[acc-1]<amt) return false;
        bal[acc-1]-=amt;
        return true;
    }
}

public class SimpleBankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of accounts:");
        int n = sc.nextInt();
        long[] balance = new long[n];       // [[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
        for(int i = 0; i < n; i++) {
            balance[i] = sc.nextLong();
        }
        sc.close();
        solution bank = new solution(balance);
        // Example operations Input
        String[] operations = {"Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"};
        int[][] values = {{}, {3, 10}, {5, 1, 20}, {5, 20}, {3, 4, 15}, {10, 50}};
        for (int i = 1; i < operations.length; i++) {
            String op = operations[i];
            int[] val = values[i];
            boolean result = false;
            switch (op) {
                case "transfer":
                    result = bank.transfer(val[0], val[1], val[2]);
                    System.out.println("Transfer from account " + val[0] + " to account " + val[1] + " of amount " + val[2] + ": " + result);
                    break;
                case "deposit":
                    result = bank.deposit(val[0], val[1]);
                    System.out.println("Deposit to account " + val[0] + " of amount " + val[1] + ": " + result);
                    break;
                case "withdraw":
                    result = bank.withdraw(val[0], val[1]);
                    System.out.println("Withdraw from account " + val[0] + " of amount " + val[1] + ": " + result);
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }   
    }
}
