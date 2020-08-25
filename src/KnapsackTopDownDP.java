import java.util.Arrays;

public class KnapsackTopDownDP {

    static int[] wt = {1, 3, 4, 5}; // profit
    static int[] val  = {1, 4, 5, 7};  // weight
    static int w = 7, n = wt.length;

    static int[][] t = new int[n+1][w+1];

    public static int knapsack ( int[] wt, int[] val, int w, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }

    public static void main ( String[] args ) {

        // filling the 1st row 1st col with -1
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                }
            }
        }

        System.out.println("Max Profit: "+knapsack(wt, val, w, n));


        // printing the table
        for (int[] ints : t) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
