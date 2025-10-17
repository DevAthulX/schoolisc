// Question 2 2026

// Write a program to declare a single-dimensional array A of size L, where L is an integer greater than or equal to 3 and less than or equal to 50. Allow the user to input integers into this array. Display an appropriate error message for an invalid input.

// Perform the following tasks on the array:

// (a) Display the array.

// (b) Find and print all equilibrium indices in increasing order. An index / (0-based) is called an equilibrium index if the sum of elements on its left equals the sum of elements on its right.

// (c) If no equilibrium index exists, display an appropriate message

// Test your program with the following data and some random data:

// Example 1

// INPUT:

// L=7

// Array Elements: 2,3,-1,8,4,-2,2

// OUTPUT:

// 2,3,-1, 8, 4,-2,2 Array:

// Equilibrium Indices: 3

// Example 2

// INPUT: L-5

// Array Elements: 0,-7,3,-2,6

// OUTPUT:

// Array: 0,-7,3,-2,6

// Equilibrium Indices: 0

// Example 3

// INPUT:

// L=6

// Array Elements: 1, 2, 3, 4, 5, 6

// OUTPUT: Array:

// 1, 2, 3, 4, 5, 6

// Equilibrium Indices: NIL

// Example 4

// INPUT:

// L=7

// Array Elements: -7, 1, 5, 2, -4, 3,0

// OUTPUT:

// Array:

// -7, 1, 5, 2, -4, 3,0

// Equilibrium Indices: 3, 6

// Example 5

// INPUT:

// L-2

// OUTPUT: INVALID INPUT
import java.util.Scanner;

public class Array {
    int[] A;
    int len;
    Array(int length) {
        len = length;  
        A = new int[len];
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter");
        for (int i = 0; i < len; i++) {
            A[i] = sc.nextInt();
        }
    }

    public void findEquilibrium() {
        int totalSum = 0;
        for (int i = 0; i < len; i++) {
            totalSum += A[i];
        }

        int leftSum = 0;
        boolean found = false;

        System.out.println("The equilibrium indices ");
        for (int i = 0; i < len; i++) {
            int rightSum = totalSum - leftSum - A[i];
            if (leftSum == rightSum) {
                System.out.print(i + "\t");
                found = true;
            }
            leftSum += A[i];
        }

        if (!found) {
            System.out.print("NIL");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array:");
        int len = sc.nextInt();
        if (len <= 0) {
            System.out.println("Invalid array length");
            System.exit(0);
        }
        Array a = new Array(len);
        a.input();
        a.findEquilibrium();

        sc.close();
    }
}
