import java.util.*;

public class Algorithms {

    // -------------------- Fibonacci --------------------
    // Recursive
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n; // base case
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative (Optimized)
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    // -------------------- Factorial --------------------
    // Recursive
    public static int factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1; // base case
        return n * factorialRecursive(n - 1);
    }

    // Iterative
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // -------------------- N-Queens --------------------
    static int N = 4;

    public static boolean isSafe(int board[][], int row, int col) {

        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check right diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static boolean solveNQueens(int board[][], int row) {
        if (row == N) return true;

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                if (solveNQueens(board, row + 1))
                    return true;

                board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void printBoard(int board[][]) {
        for (int[] row : board) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    // -------------------- Main --------------------
    public static void main(String[] args) {

        System.out.println("Fibonacci (Recursive): " + fibonacciRecursive(6));
        System.out.println("Fibonacci (Iterative): " + fibonacciIterative(6));

        System.out.println("Factorial (Recursive): " + factorialRecursive(5));
        System.out.println("Factorial (Iterative): " + factorialIterative(5));

        int board[][] = new int[N][N];

        if (solveNQueens(board, 0)) {
            System.out.println("N-Queens Solution:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}