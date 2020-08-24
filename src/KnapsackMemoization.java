/*
 * Input:
 * wt[]  = [1, 3, 4, 5]
 * val[] = [1, 4, 5, 7]
 * Max capacity = 7
 *
 * Output: Find the max profit
 */


import java.util.Arrays;

public class KnapsackMemoization {
    static int w = 7, n = 4;

    static int[][] t = new int[n+1][w+1];


    public static int knapsack ( int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0){
            return 0;
        }

        if (t[n][w] != -1) {
            return t[n][w];
        }

        else if (wt[n-1] <= w) {
            return t[n][w] = Math.max(val[n-1] + knapsack(wt, val, w-wt[n-1], n-1), knapsack(wt, val, w, n-1)  );
        }
        else if (wt[n-1] > w) {
            return t[n][w] = knapsack(wt, val, w, n-1);
        }
        return 0;
    }


    public static void main ( String[] args ) {
        int[] wt  = {1, 3, 4, 5}; // weight
        int[] val = {1, 4, 5, 7}; // profit

        // filling the table with -1
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }

        System.out.println("Max profit: " + knapsack(wt, val, w, n));

        // printing the table
//        for (int[] ints : t) {
//            System.out.println(Arrays.toString(ints));
//        }

    }
}
