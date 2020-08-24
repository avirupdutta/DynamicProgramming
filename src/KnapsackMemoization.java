/*
* Input:
* wt[]  = [1, 3, 4, 5]
* val[] = [1, 4, 5, 7]
* Max capacity = 7
*
* Output: Find the max profit
*/


public class KnapsackMemoization {

    public static int knapsack( int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0){
            return 0;
        }
        else if (wt[n-1] <= w) {
            return Math.max(val[n-1] + knapsack(wt, val, w-wt[n-1], n-1), knapsack(wt, val, w, n-1)  );
        }
        else if (wt[n-1] > w) {
            return knapsack(wt, val, w, n-1);
        }
        return 0;
    }


    public static void main ( String[] args ) {
        int[] wt  = {1, 3, 4, 5}; // weight
        int[] val = {1, 4, 5, 7}; // profit
        int w = 7, n = 4;

        System.out.println("Max profit: " + knapsack(wt, val, w, n));

    }
}
