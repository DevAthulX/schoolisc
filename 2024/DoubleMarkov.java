import java.util.*;
// Question 2

// Write a program to declare a square matrix M of order "N". Check if the matrix is a D Markov matrix or not. A matrix which satisfies the following conditions are Doubly Markov

// (6) All elements are greater than or equal to 0

// (ii) Sum of each row is equal to 1.

// Sum of each column is equal to 1. (iii)

// the given range or the entered numbers are negative. Allow the user to create a matrix and Accept 'N' from the user where 3 <= N <= 9. Display an appropriate error message if 'N' is whether the created matrix is a Doubly Markov matrix or not

// Test your program for the following data and some random data:

// Example 1

// INPUT:

// N-3

// Enter elements in the matrix: 0.5, 0.25, 0.25, 0.25, 0.75, 0.0, 0.25, 0.0, 0.75

// OUTPUT: FORMED MATRIX

// 0.5

// 0.25

// 0.25

// 0.25 0.75 0.0

// 0.25 0.0

// 0.75

// IT IS A DOUBLY MARKOV MATRIX

// Example 2

// INPUT:

// N-3

// Enter elements in the matrix: 1.5, 3, 0.15, 0.25, 4, 1.0, 0.25, 1.0, 3

// OUTPUT: FORMED MATRIX

// 1.5

// 3

// 0.25 4

// 0.15

// 1.0

// 0.25 1.0 3

// IT IS NOT A DOUBLY MARKOV MATRIX

// Example 3

// INPUT:

// N=2

// Enter elements in the matrix: 0.8, -4.0, 0.9, 3.5

// OUTPUT:

// NEGATIVE NUMBERS ENTERED. INVALID ENTRY

// Example 4

// INPUT:

// N=12

// OUTPUT: SIZE IS OUT OF RANGE. INVALID ENTRY
public class DoubleMarkov {
    int n;
    double a[][];

    DoubleMarkov(int x) {
        n = x;
        a = new double[n][n];
    }

    void input() {
        if (n < 3 || n > 9) {
            System.out.println("SIZE IS OUT OF RANGE. INVALID ENTRY");
            System.exit(0);
        }
        Scanner sc = new Scanner(System.in);
        boolean isNegative = false;
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextDouble();
                if (a[i][j] < 0) {
                    isNegative = true;
                }
            }
        }
        if (isNegative) {
            System.out.println("NEGATIVE NUMBERS ENTERED. INVALID ENTRY");
            System.exit(0);
        }
    }

    void print() {
        System.out.println("FORMED MATRIX");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    void check() {
        boolean isDoubleMarkov = true;

        for (int i = 0; i < n; i++) {
            double rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += a[i][j];
            }
            if (rowSum != 1.0) {
                isDoubleMarkov = false;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            double colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += a[i][j];
            }
            if (colSum != 1.0) {
                isDoubleMarkov = false;
                break;
            }
        }

        if (isDoubleMarkov) {
            System.out.println("IT IS A DOUBLY MARKOV MATRIX");
        } else {
            System.out.println("IT IS NOT A DOUBLY MARKOV MATRIX");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix:");
        int n = sc.nextInt();
        DoubleMarkov ob = new DoubleMarkov(n);
        ob.input();
        ob.print();
        ob.check();
    }
}
