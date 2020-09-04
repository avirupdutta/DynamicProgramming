import java.util.Arrays;

public class DisplayTable {
    public static void display2DTable(int[][] table) {
        for (int[] ints : table) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
