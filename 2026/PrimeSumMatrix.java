// Question 2

// and 'N' is the number of columns such that both M (MN) and N must be greater than 2 and less than 10. Allow the user to input positive integers into this matrix Display appropriate etror message Write a program to declare a matris Al || of order where 'M' is the number of rows for an invalid input.

// Perform the following tasks on the matris

// (a) Display the input matrix

// (b) Compute the sum of prime elements for each row and column (c) Identify the row index with maximum prime-sum and the column index with maximum prime-sum.

// (d) Print both indices and sums, if no primes found in all, print a message 7
import java.util.Scanner;

public class PrimeSumMatrix {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        if (M <= 2 || M >= 10 || N <= 2 || N >= 10) {
            System.out.println("INVALID INPUT");
            return;
        }

        int[][] matrix = new int[M][N];
        boolean invalidInput = false;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
                if (matrix[i][j] <= 0) invalidInput = true;
            }
        }

        if (invalidInput) {
            System.out.println("INVALID INPUT");
            return;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int[] rowPrimeSum = new int[M];
        int[] colPrimeSum = new int[N];
        boolean hasPrime = false;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isPrime(matrix[i][j])) {
                    rowPrimeSum[i] += matrix[i][j];
                    colPrimeSum[j] += matrix[i][j];
                    hasPrime = true;
                }
            }
        }

        if (!hasPrime) {
            System.out.println("No prime numbers found in the matrix.");
            return;
        }

        int maxRowSum = rowPrimeSum[0];
        int rowIndex = 0;
        for (int i = 1; i < M; i++) {
            if (rowPrimeSum[i] > maxRowSum) {
                maxRowSum = rowPrimeSum[i];
                rowIndex = i;
            }
        }

        int maxColSum = colPrimeSum[0];
        int colIndex = 0;
        for (int j = 1; j < N; j++) {
            if (colPrimeSum[j] > maxColSum) {
                maxColSum = colPrimeSum[j];
                colIndex = j;
            }
        }

        System.out.println("Row with max prime-sum: " + rowIndex + " (sum = " + maxRowSum + ")");
        System.out.println("Column with max prime-sum: " + colIndex + " (sum = " + maxColSum + ")");
    }
}

