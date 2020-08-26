import java.util.Arrays;

public class SubsetSum {

    public static boolean checkSubsetSum(int n, int sum, boolean[][] table, int[] arr) {

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (arr[i-1] <= j){
                    table[i][j] = table[i-1][j-arr[i-1]] || table[i-1][j];
                }
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[n][sum];
    }

    public static void main ( String[] args ) {
        int[] arr = {2, 3, 10, 7};
        int sum = 5;
        int n = arr.length;
        boolean[][] table = new boolean[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = true;
                }
                else if (i == 0) {
                    table[i][j] = false;
                }
                else if (j == 0) {
                    table[i][j] = true;
                }
            }
        }

        System.out.println("Is Available: "+checkSubsetSum(n, sum, table, arr));

        // printing the table
        for (boolean[] subArr : table) {
            System.out.println(Arrays.toString(subArr));
        }

    }
}
