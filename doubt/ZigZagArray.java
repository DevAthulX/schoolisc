package doubt;
import java.util.Scanner;
// Question 2

// Write a program to declare a single-dimensional array arr[ ] of size N, where N is an integer greater than 2 and less than 10. Allow the user to input positive integers into this array. Display an appropriate error message for an invalid input.

// Rearrange the array in zig-zag order in the form arr0 <arrl > arr2 < arr3 2 arr4 in-place swaps only. using

// Example: Input: [4, 3, 7, 8, 6, 2, 1]

// Output: [3, 7, 4, 8, 2, 6, 1] after rearranging in zig-zag order.

// Perform the following tasks on the array:

// (a) Display original array.

// (b) Transform to zig-zag order.

// (c) Display transformed array.

// Test your program with the following data and some random data:

// Example 1

// INPUT:

// N-5

// Array Elements: 20, 5, 25, 30, 18

// OUTPUT:

// Original Array:

// 20, 5, 25, 30, 18

// Zig-zag Array:

// 5, 25, 20, 30, 18

// Example 2

// INPUT:

// N-8

// Array Elements:

// 100, 50, 175, 25, 12, 150, 17, 200

// OUTPUT:

// Original Array:

// 100, 50, 175, 25, 12, 150, 17, 200

// Zig-zag Array:

// 50, 175, 100, 150, 12, 25, 17, 200

// Example 3

// INPUT:

// N=6

// Array Elements:

// 21, 4, 34, -2,9 10

// OUTPUT: INVALID INPUT

// Example 4

// INPUT:

// N-4

// OUTPUT:

// INVALID INPUT using the even position algorith
public class ZigZagArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array (3-9): ");
        int N = sc.nextInt();

        if (N <= 2 || N >= 10) {
            System.out.println("INVALID INPUT");
            return;
        }

        int[] arr = new int[N];
        System.out.println("Enter " + N + " positive integers:");

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] <= 0) {  // 
                System.out.println("INVALID INPUT");
                return;
            }
        }
        System.out.println("Original Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i != N - 1) System.out.print(", ");
        }
        System.out.println();
        for (int i = 0; i < N - 1; i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            } else {
              
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

     
        System.out.println("Zig-zag Array:");
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i != N - 1) System.out.print(", ");
        }
        System.out.println();

        sc.close();
    }
}
