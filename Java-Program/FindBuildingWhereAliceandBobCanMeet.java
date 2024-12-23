import java.util.Scanner;

public class FindBuildingWhereAliceandBobCanMeet {
    private static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            result[i] = -1;
            if (a < 0 || a >= n || b < 0 || b >= n) {
                continue;
            }
            if (a == b && heights[a] == heights[b]) {
                result[i] = a;
            } else {
                int start = Math.max(a, b);
                int h2c = heights[start];
                for (int j = start + 1; j < n; j++) {
                    if (heights[j] < h2c) {
                        result[i] = j;
                        break;
                    }
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n");
        int n = sc.nextInt();
        int[] heights = new int[n];
        System.out.println("Enter heights");
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println("enter m");
        int m = sc.nextInt();
        int[][] queries = new int[m][2];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter queries");
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }
        sc.close();

        int[] result = leftmostBuildingQueries(heights, queries);
        System.out.println("result : ");
        for (int i = 0; i < m; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
