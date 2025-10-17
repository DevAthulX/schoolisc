import java.util.Scanner;
// Question 2

// Lucky numbers are a sequence of natural numbers that remain after removing second, third, fourth, fifth and so on numbers respectively from a sequence of consecutive natural numbers.

// Consider the sequence of first 20 natural numbers:

// Removing every second number produces the sequence 1, 3, 5, 7, 9, 11, 13, 15, 17, 19

// Next removing every third number produces the sequence 1, 3, 7, 9, 13, 15, 19

// Next removing every fourth number produces the sequence: 1, 3, 7, 13, 15, 19

// Further deleting every fifth number we get the sequence: 1, 3, 7, 13, 19

// Deletion of every sixth number is not possible and the five numbers that are lucky to escape deletion remain indefinitely.

// Write a program to enter any positive natural number 'N' where (1<=N<=50) and generate lucky numbers less than the given natural number.

// Test your program with the following set of data

// Example 1

// INPUT:

// N=10

// OUTPUT: LUCKY NUMBERS LESS THAN 10 ARE: 1,3,7

// Example 2

// INPUT:

// N-25

// OUTPUT:

// LUCKY NUMBERS LESS THAN 25 ARE: 1, 3, 7, 13, 19

// Example 3

// INPUT:

// N-100

// OUTPUT:

// NUMBER NOT IN RANGE. INVALID ENTRY
public class LuckyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int N = sc.nextInt();

        if (N < 1 || N > 50) {
            System.out.println("NUMBER NOT IN RANGE. INVALID ENTRY");
            return;
        }

    
        int[] numbers = new int[N];
        int size = N;
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }
        int stepIndex = 2; 
        while (stepIndex < size+1) {
            

            int count = 0;
            int counter = 0; 
            for (int i = 0; i < size; i++) {
                counter++;
                if (counter % stepIndex != 0) {
                    numbers[count] = numbers[i];
                    count++;
                }
            }
            size = count;
            stepIndex++;
        }

     
        System.out.print("LUCKY NUMBERS LESS THAN " + N + " ARE: ");
        for (int i = 0; i < size; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
