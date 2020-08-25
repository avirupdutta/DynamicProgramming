/**
 * Display first 'n' Fibonacci numbers:-
 * -------------------------------------
 * Input:
 * 10
 *
 * Output:
 * 0 1 1 2 3 5 8 13 21 34
 * */


public class RecursiveFibonacci {
    public static void displayFibonacci(int n, int a, int b) {
        if (n == 0) return;
        System.out.print((a+b) + " ");
        displayFibonacci(n-1, b, a+b);
    }
    public static void main ( String[] args ) {
        int n = 10;

        displayFibonacci(n, 0, 1);
    }
}
