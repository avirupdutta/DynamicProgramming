public class RecursiveFactorial {
    public static int getFactorial(int n, int fact) {
        if (n == 1) {
            return fact;
        }
        return getFactorial(n-1, n*fact);
    }
    public static void main ( String[] args ) {
        int limit = 32;

        System.out.println(getFactorial(limit, 1));
    }
}
