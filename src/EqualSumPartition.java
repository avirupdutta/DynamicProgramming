public class EqualSumPartition {

    public static boolean checkSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] table = new boolean[n+1][sum+1];

        // initializing the table
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

        // main dp code
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

    public static boolean checkEqualSumPartition(int[] arr) {
        int sum = 0;
        for (int j : arr) sum += j;

        if (sum % 2 != 0) {
            return false;
        }
        return checkSubsetSum(arr, sum/2);
    }

    public static void main ( String[] args ) {
        int[] arr = {2, 5, 13, 5, 1};

        System.out.println("Is Available: "+checkEqualSumPartition(arr));

    }
}
