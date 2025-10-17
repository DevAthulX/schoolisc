// Question 1 2026

// A distinct-prime-digit integer is a positive integer (without leading zeros) in which all digits For example, 2. 37,253 are distinct-prime-digit integers, whereas 33, 252, 29 are not. are prime numbers and no digit is repeated. The prime digits are 2. 3. 5. 7.

// Given two positive integers m and n, where write a program to determine how many distinct-prime-digit integers are there in the range m < n between mand n (both inclusive) and output them.

// Test your program for the following data and some random data:

// Example 1

// INPUT: m = 20 n = 60

// OUTPUT: THE DISTINCT-PRIME-DIGIT INTEGERS ARE: 23, 25, 27, 32, 35, 37, 52, 53, 57 FREQUENCY OF DISTINCT-PRIME-DIGIT INTEGERS IS: 9

// Example 2

// INPUT: n = 120 m = 70

// OUTPUT: THE DISTINCT-PRIME-DIGIT INTEGERS ARE: 72, 73, 75, 77 FREQUENCY OF DISTINCT-PRIME-DIGIT INTEGERS IS: 4

// Example 3

// INPUT: n = 180 m = 100

// OUTPUT: THE DISTINCT-PRIME-DIGIT INTEGERS ARE: NIL FREQUENCY OF DISTINCT-PRIME-DIGIT INTEGERS IS: 0

// Example 4

// INPUT: n = 150 m = 200

// OUTPUT: INVALID INPUT
import java.util.Scanner;

public class DistinctPrime {
    int m, n;
    int a[];

    void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter range");
        m = sc.nextInt();
        n = sc.nextInt();
        a = new int[n - m + 1];
        int k = 0;
        for (int i = m; i <= n; i++) {
            a[k++] = i;
        }
    }

    boolean isPrimeDigit(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7);
    }

    void distinctPrime() {
        int count = 0;
        System.out.println("distinct prime");
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int temp = num;
            boolean allPrimeDigits = true;

            while (temp > 0) {
                int digit = temp % 10;
                if (!isPrimeDigit(digit)) {
                    allPrimeDigits = false;
                    break;
                }
                temp /= 10;
            }

            if (allPrimeDigits) {
                System.out.print(num + "\t");
                count++;
            }
        }

        System.out.println("The frequency " + count);
    }

    public static void main(String[] args) {
        DistinctPrime ob = new DistinctPrime();
        ob.input();
        ob.distinctPrime();
    }
}
