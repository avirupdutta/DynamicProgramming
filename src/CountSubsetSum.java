import java.util.Arrays;

public class CountSubsetSum {

    public static int countSubsetSum(int[] arr, int sum) {
        int[][] table = new int[arr.length+1][sum+1];

//        initializing the table
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                table[i][j] = 0;
            }
            table[i][0] = 1;
        }

//        main dp algorithm
        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < sum+1; j++) {

                if (arr[i-1] <= j){
                    table[i][j] = table[i-1][j] + table[i-1][j-arr[i-1]];
                }
                else {
                    table[i][j] = table[i-1][j];
                }

            }
        }

        for (int[] ints : table) {
            System.out.println(Arrays.toString(ints));
        }

        return table[arr.length][sum];
    }

    public static void main ( String[] args ) {
        int[] arr = {2, 5, 3};
        int sum = 5;
        System.out.println("Is Available: "+countSubsetSum(arr, sum));
    }
}
