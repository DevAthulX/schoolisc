import java.util.Scanner;
// SAMPLE PAPER 1

// Solve any one of the following Problems.

// Question 1

// Hamming numbers are positive integer numbers whose prime factors include 2,3 and 5 only

// Example:

// n = 6 is an hamming number as 6 = 2 * 3 .So its prime factors are limited to 2,3

// n = 8i an hamming number as 8 = 2 * 2 * 2 and it has only 2 as its prime factors

// n = 90 is an hamming number as 90 = 2 * 3 * 3 * 5 which has only 2,3,5 as prime factors

// n = 14 is not a hamming number as 14 = 2 * 7 It has 7 as one of its prime factor

// n = 44 is not a hamming number as 44 = 2 * 2 * 11 It has 11 as one of its prime factors

// Design a program to accept any positive integer number and check if it is a Hamming number or not. Display the result with an appropriate message in the format specified below. The program should also generate error message if a negative number is entered.

// Test your program for the following data and some random data.

// Example 1

// INPUT:

// Enter any number: 3600

// OUTPUT:

// 3600 = 2 * 2 * 2 * 2 * 3 * 3 * 5 * 5

// 3600 IS A HAMMING NUMBER

// Example 2

// INPUT:

// Enter any number: 5832

// OUTPUT:

// \$ 832 = 2 * 2 * 2 * 3 * 3 * 3 * 3 * 3 * 3

// Example 3

// 5832 IS A HAMMING NUMBER

// INPUT:

// Enter any number: 7854

// OUTPUT: 7854 = 2 * 3 * 7 * 11 * 17

// 7854 IS NOT A HAMMING NUMBER

// Example 4

// INPUT:

// Enter a number: -120

// OUTPUT:

// NEGATIVE NUMBER ENTERED. INVALID INPUT
public class HammingNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("negative number entered. invalid input");
            return;
        }

        if (num == 0) {
            System.out.println("0 is not a hamming number");
            return;
        }

        int originalNum = num;
        boolean isHamming = true;

        System.out.print(originalNum + " = ");

        boolean first = true; 
        int[] allowedPrimes = {2, 3, 5};
        for (int prime : allowedPrimes) {
            while (num % prime == 0) {
                if (!first) {
                    System.out.print(" * ");
                }
                System.out.print(prime);
                first = false;
                num /= prime;
            }
        }

     
        if (num > 1) {
            if (!first) {
                System.out.print(" * ");
            }
            System.out.print(num);
            isHamming = false;
        }

        System.out.println(); 
        if (isHamming) {
            System.out.println(originalNum + " is a hamming number");
        } else {
            System.out.println(originalNum + " is not a hamming number");
        }
    }
}
