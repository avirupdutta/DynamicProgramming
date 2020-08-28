import java.util.Arrays;

public class CountSubsetWithDiff {

    public static int countSubsetSum(int[] arr, int sum) {
        int[][] table = new int[arr.length+1][sum+1];
        
//        table initialization
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                table[i][j] = 0;
            }
            table[i][0] = 1;
        }


        for (int i = 1; i < table.length; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (arr[i-1] <= j) {
                    table[i][j] = table[i-1][j] + table[i-1][j - arr[i-1]];
                }
                else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

//        for (int[] ints : table) {
//            System.out.println(Arrays.toString(ints));
//        }
        
        return table[arr.length][sum];
    }
    

    public static int countSubsetWithDiff(int[] arr, int diff) {
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }
        int sum = (arrSum + diff) / 2;
        return countSubsetSum(arr, sum);
    }


    public static void main ( String[] args ) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        System.out.println("Is Available: "+countSubsetWithDiff(arr, diff));
    }
}
