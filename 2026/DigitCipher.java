// SAMPLE PAPER 1

// Solve any one of the following Problems.

// Question 1 2026

// Digit Permutation Cipher is a simple form of number encryption where the digits of a Bumber are rearranged based on a given key where (1 key size of the number). The key is a sequence of integers that defines the new positions of the digits.

// Example: If number - 2613 and key = 4213, then the encrypted number will be 1632 by positioning the first digit to the 4th place, second digit to the second place, third digit to the first place and the fourth digit to the third place as per the key given.

// Write a program to enter a number and a permutation key (a sequence of digits which is greater than 0 and less than or equal to the size of the number). The program should encrypt the number by permuting its digits according to the key. The number of digits in the key must match the number of digits in the number to be encrypted.

// Test your program with the following data and some random data:

// Example 1

// INPUT:

// Number: 12345

// Key: 31524

// OUTPUT: The encrypted number is 24153

// Example 2

// Number: 9876

// INPUT:

// Key:

// 4132

// OUTPUT:

// The encrypted number is 8679

// Example 3

// INPUT: Number: 5239

// Key:

// 4765

// OUTPUT:

// INVALID KEY DIGITS

// Example 4

// INPUT:

// Number: 123

// Key:

// 2134

// OUTPUT:

// INVALID KEY SIZE
import java.util.Scanner;

public class DigitCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number");
        String number = scanner.nextLine();
        
        System.out.print("Enter key  ");
        String keyStr = scanner.nextLine();
        int[] key = new int[keyStr.length()];
        for (int i = 0; i < keyStr.length(); i++) {
            key[i] = Character.getNumericValue(keyStr.charAt(i)) - 1;
        }
        
        if (number.length() != key.length) {
            System.out.println("length of number and key must be equal");
            System.exit(0);
        }
        
        char[] digits = number.toCharArray();
        char[] encrypted = new char[digits.length];
        for (int i = 0; i < digits.length; i++) {
            encrypted[key[i]] = digits[i];
        }
        
        System.out.println("Encrypted number" + new String(encrypted));
        
        scanner.close();
    }
}