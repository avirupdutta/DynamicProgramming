/*
Coin Change Problem Minimum Numbers of coins
Given a value V, if we want to make change for V cents,
and we have infinite supply of each of C = { C1, C2, .. , Cm}
valued coins, what is the minimum number of coins to make the change?
Example:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents

PROBLEM STATEMENT
LINK:https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

*/

public class MinimumCoinChange {

    public static int calcMinimumCoinChange( int[] coins, int sum) {
        int INT_MAX = Integer.MAX_VALUE;
        int[][] t = new int[coins.length+1][sum+1];
        
        // initializing the table
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= sum; j++) {
                t[0][j] = INT_MAX - 1;
                t[i][0] = 0;

                // initializing the 2nd row
                if (i == 1 && j > 0) {
                    if (j % coins[0] == 0) {
                        t[i][j] = j / coins[0];
                    } else {
                        t[i][j] = INT_MAX - 1;
                    }
                }
            }
        }
        
        // main part
        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i-1] <= j) {
                  t[i][j] = Math.min(t[i-1][j], t[i][j-coins[i-1]]+1);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // displays the table
        DisplayTable.display2DTable(t);

        return t[coins.length][sum];
    }

    public static void main ( String[] args ) {
        int[] coins = {25, 10, 5};
        int v = 5;

        System.out.println("The minimum coins required is: "+calcMinimumCoinChange(coins, v));
    }
}
