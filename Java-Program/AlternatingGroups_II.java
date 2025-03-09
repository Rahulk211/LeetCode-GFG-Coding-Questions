public class AlternatingGroups_II {

    private static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int count = 0;
        int l = 0;
        int limit = n + k - 1;

        while (l < n) {
            int r = l + 1;
            while (r < limit && colors[(r - 1) % n] != colors[r % n]) {
                r++;
            }
            if (r - l >= k) {
                count += (r - l + 1) - k;
            }
            l = r;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] colors = { 0, 1, 0, 0, 1, 0, 1 };
        int k = 6;

        System.out.println(numberOfAlternatingGroups(colors, k));
    }
}
