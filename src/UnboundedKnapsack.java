import java.util.Arrays;

public class UnboundedKnapsack {

    public static int unboundedKnapsack ( int[] wt, int[] val, int w) {
        int n = wt.length;
        int[][] t = new int[n+1][w+1];

        // filling the 1st row 1st col with 0
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < w+1; j++) {
                if (i==0 || j==0) {
                    t[i][j] = 0;
                }
            }
        }


        // unbounded knapsack
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w+1; j++) {
                if (wt[i-1] <= j) {
                    t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }

    public static void main ( String[] args ) {
        int[] val = {1, 30}; // profit
        int[] wt = {1, 50};  // weight

        System.out.println("Max Profit: "+unboundedKnapsack(wt, val, 100));
    }
}
